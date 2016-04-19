package hit.controller;
/**
 * @author 如今我已剑指天涯sunpeng
 * 
 * 用户模块控制器
 */
import hit.common.JavaMailUtils;
import hit.common.SenseTime;
import hit.mapper.SchoolMapper;
import hit.po.Club;
import hit.po.School;
import hit.po.User;
import hit.service.ClubService;
import hit.service.SchoolService;
import hit.service.UserService;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class UserController extends AbstractController {
	@Autowired
	private UserService userService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private SchoolService schoolService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}

	@RequestMapping(value="/user_login.do",method = {RequestMethod.POST })
	public @ResponseBody String login(HttpServletRequest request,@RequestParam String email,@RequestParam String password){
		 System.out.println("到达登陆后台0--------------------------------------------");
		User user = userService.selectByEmail(email);
		
		if(user==null){
			request.getSession().setAttribute("error","登录失败，该邮箱尚未注册");
//			return "jsp/error";
//			return "用户名或密码错误!";
			return "wrong username or password!";
		}else {
			User temp = userService.login(password, email);
			if(temp==null){
				request.getSession().setAttribute("error","邮箱或密码错误");
//				return "用户名或密码错误!";

				return "wrong username or password!";
			}else if(temp.getValidationstate()==1){
				temp.setUserId(user.getUserId());//妈的，这句话不加就有问题，，，，，bug终于找到了
				request.getSession().setAttribute("user",temp);
				request.getSession().setAttribute("user_id", user.getUserId());
				if(temp.getImage()!=null){
					//如果有图片，就将他显示出来
					request.getSession().setAttribute("imagePath", temp.getImage());
					System.out.println("该用户的图片是：："+temp.getImage());
				}
				System.out.println(temp.getEmail()+"我他妈想看看是谁的邮箱");
				System.out.println("登录成功，强行调转到主页");
				return "success";
			}else {
				return "Your mailbox has not been activated.";
			}
		}			
	}
	/**
	 * @author sunpeng
	 * @param request
	 * @param email
	 * @param password
	 * @param verifyCode
	 * @return
	 */
	@RequestMapping(value="/user_regist.do",method={RequestMethod.POST})
	public String regist(HttpServletRequest request , @RequestParam String email ,@RequestParam String password,@RequestParam String verifyCode ){
		
			// 首先要对验证码进行校验
				String sessionVerifyCode = (String) request.getSession().getAttribute("session_vcode");
				
				if (!sessionVerifyCode.equalsIgnoreCase(verifyCode)) {
						//说明验证码输入错误
					 	 String verifyCodeError = "";
					 	 System.out.println("验证码输入错啦");
						request.setAttribute("errorMsg", "验证码输入错误");
						return "jsp/error";
				}else {
					User temp = userService.selectByEmail(email);
					if (temp!=null) {
						System.out.println("该邮箱已经被注册");
						request.setAttribute("errorMsg", "该邮箱已经被注册");
						return "jsp/error";
					}
					else {				
					   User user = new User();
						user.setEmail(email);
						user.setPassword(password);
						System.out.println("创建用户user");
						user.setValidationstate(0);//未激活，此时是0
						//调用创建用户的方法
						String flag = userService.addUser(user);	
						String keyCode = UUID.randomUUID().toString().replace("-","") +""+ UUID.randomUUID().toString().replace("-", "");     //激活key，用于激活邮件
						
						String url = "http://localhost:8080/Quiclub/user_active.do?key="   ;
						
						JavaMailUtils.sendMail(user.getEmail(), "激活邮件，请点击下面链接完成激活操作！",
								"<a href='" + url +keyCode+ "&email=" + user.getEmail() +"'>" + "</a><br/>");//发送激活邮件
						user.setKeyCode(keyCode);//入库
						userService.updateUserByEmail(user);
						request.getSession().setAttribute("user", user);//将用户放入到session域中
						request.getSession().setAttribute("user_id", user.getUserId());
						if (flag.equals("success")) {
							return "jsp/toActive";
						}
						return "";		
					}
				}
	}
	
	/**
	 * 更新用户信息，包括文件上传
	 * @author sunpeng123
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/user_update.do",method={RequestMethod.POST})
	public String update(HttpServletRequest request,@RequestParam(defaultValue="papapa") String username,
			@RequestParam(defaultValue="papapa") String schoolname,@RequestParam(defaultValue="papapa") String institute,@RequestParam(defaultValue="papapa") String major,
			@RequestParam(defaultValue="papapa") String time,@RequestParam(defaultValue="papapa") String phone,@RequestParam(defaultValue="papapa") String sex,
			@RequestParam(defaultValue="papapa") String scholar,@RequestParam(defaultValue="papapa") String province,@RequestParam(value = "image", required = false) MultipartFile image) throws UnsupportedEncodingException{
		User user = (User) request.getSession().getAttribute("user");//从request中获取user
		System.out.println("当前用户是"+user.getEmail());
		User userNew = userService.update(request,user,username,schoolname,institute,major,time,phone,sex,province,image,scholar);
		request.setCharacterEncoding("UTF-8");
		//调用user的更新方法
		userService.updateUser(userNew);		
		request.getSession().removeAttribute("user");
		request.getSession().setAttribute("user", userNew);
		return "forward:index.jsp";
			
	}
	/**
	 * 注销登录
	 * @return
	 */
	@RequestMapping(value="/user_quit.do")
	public String quit(HttpServletRequest request){
		User user = (User) request.getAttribute("user");
		request.getSession().removeAttribute("user");		//将user对象从session中移除
		System.out.println("注销成功。。。");
		return "forward:index.jsp";
	}
	/**
	 * 我的信息
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:
	TODO
	 *创建时间:2016年4月6日下午9:11:40
	 * @return
	 */
	@RequestMapping(value="/MyInfo.do")
	public String MyInfo(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null) {
			request.setAttribute("errorMsg", "麻麻说往地址栏敲东西的人都不是什么好人。");
			return "jsp/error";
		}else{
			return "jsp/manager1";			
		}
	}
	
	/**
	 * 编辑信息
	 * @author sunpeng123
	 * @time
	 * 
	 */
	@RequestMapping(value="/editInfo.do")
	public  String editInfo(){
		return "jsp/manager";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return
	 */
	@RequestMapping(value="/toClubPage.do",method={RequestMethod.GET})
	public String toClubPage(HttpServletRequest request,Integer club_id){
		request.getSession().setAttribute("club_id", club_id);
		Integer user_id = (Integer) request.getSession().getAttribute("user_id");
		if (user_id ==  null) {
			user_id = 1;
		}
		List<Integer> menu_ids = clubService.getRoleMenu(clubService.getUserRoleInClub(user_id, club_id).getRoleId());
		request.setAttribute("menu_ids", menu_ids);
		return "jsp/CommunityManager";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return
	 */
	@RequestMapping(value="/getUserClubs.do")
	public String getUserClubs(HttpServletRequest request){
		Integer user_id = (Integer) request.getSession().getAttribute("user_id");
		if (user_id == null) {
			user_id = 1;
		}
		List<Club> clubs = clubService.getClubsByUser(user_id);
		request.setAttribute("clubs", clubs);
		return "jsp/myCommunity";
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:激活账号的方法
	 * @return
	 */
	@RequestMapping(value="/user_active.do")
	public String active(HttpServletRequest request) {
		String temp = request.getParameter("key");//获取到了
		String email = request.getParameter("email");//OK
		User user = userService.selectByEmail(email);
		if(user.getKeyCode().equals(temp)){
			//激活成功
			user.setValidationstate(1);//已激活
			userService.updateUser(user);
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "激活成功，请完善信息");
			return "jsp/manager";
		}else{
			request.setAttribute("error","激活失败，请返回到您的邮箱查看");
			return "jsp/error";
		}
		
	}
	
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:这是用户选择请求加入社团的方法
	 *创建时间:2016年4月16日下午8:40:42
	 * @return
	 */
	@RequestMapping(value="/joinClub.do",method={RequestMethod.GET})
	public @ResponseBody String joinClub(HttpServletRequest request,
								@RequestParam(defaultValue="0") Integer clubId) {
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("用户和请求的club分别是:"+user.getUsername()+ "-------"+clubId);
		Integer user_id = user.getUserId();
		//判断该用户是否已经提交过请求
		Boolean flag = true;
		flag = userService.judgeRequest(user_id,clubId);
		if (flag==false) {
			userService.joinClub(user_id,clubId);	
			System.out.println("该用户的请求已经插入到数据库中");
			return "success";
		}else {
			System.out.println("重复提交请求");
			return "error";
		}
	}
	
}

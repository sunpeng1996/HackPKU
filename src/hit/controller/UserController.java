package hit.controller;
/**
 * @author 如今我已剑指天涯sunpeng
 * 
 * 用户模块控制器
 */
import hit.mapper.SchoolMapper;
import hit.po.School;
import hit.po.User;
import hit.service.SchoolService;
import hit.service.UserService;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class UserController extends AbstractController {
	@Autowired
	private UserService userService;
	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private SchoolService schoolService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}

	
	@RequestMapping(value="/user_login.do",method = {RequestMethod.POST })
	public String login(HttpServletRequest request,@RequestParam String email,@RequestParam String password){
		 System.out.println("到达登陆后台0--------------------------------------------");
		User user = userService.selectByEmail(email);
	
		if(user==null){
			request.getSession().setAttribute("error","登录失败，该邮箱尚未注册");
			return "jsp/error";
		}else{
			User temp = userService.login(password, email);
			if(temp==null){
				request.getSession().setAttribute("error","邮箱或密码错误");
				return "jsp/error";
			}else{
				request.getSession().setAttribute("user",temp);
				System.out.println(temp.getEmail()+"我他妈想看看是谁的邮箱");
				System.out.println("登录成功，强行调转到主页");
				return "index";
			}
		}			
	}
	
	@RequestMapping(value="/user_regist.do",method={RequestMethod.POST})
	public String regist(HttpServletRequest request , @RequestParam String email ,@RequestParam String password ){
		User temp = userService.selectByEmail(email);
		if (temp!=null) {
			System.out.println("该邮箱已经被注册");
			request.getSession().setAttribute("error", "该邮箱已经被注册");
			return "index";
		}
		else {
			
		
		User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			System.out.println("创建用户user");
			//调用创建用户的方法
			String flag = userService.addUser(user);	
			request.getSession().setAttribute("user", user);//将用户放入到session域中
			if (flag.equals("success")) {
				return "jsp/manager";
			}
			return "";		
		}
	}
	
	/**
	 * 更新用户信息，包括文件上传
	 * @author sunpeng123
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/user_update.do",method={RequestMethod.POST})
	public String update(HttpServletRequest request,@RequestParam String username,
			@RequestParam String schoolname,@RequestParam String institute,@RequestParam String major,
			@RequestParam String time,@RequestParam String phone,@RequestParam String sex,
			@RequestParam String province,@RequestParam(value = "image", required = false) MultipartFile image) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("当前用户是"+user.getEmail());
		Integer id = user.getUserId();//获取当前用户id
		String email = user.getEmail();
		String password = user.getPassword();
		user.setEmail(email);
		user.setUserId(id);
		user.setPassword(password);
		user.setPhone(phone);
		user.setProvince(province);
		user.setUsername(username);
		//通过schoolname得到school对象
		School school = userService.findSchoolBySchoolName(schoolname);	
		Integer schid = schoolService.selectSchidBySchoolName(schoolname);
		if(school==null){
			//说明school在数据库中没有，那么我们new一个就好了
			School temp = new School();
					
			temp.setSchoolname(schoolname);			
			schoolMapper.insert(temp);//持久化到数据库中	
			Integer tempid = schoolService.selectSchidBySchoolName(temp.getSchoolname());
			
			user.setSchId(tempid);
			user.setSchoolname(schoolname);
		}		else {
			user.setSchoolname(schoolname);
			user.setSchId(schid);
		}
	
		user.setMajor(major);
		user.setInstitute(institute);
		user.setTime(time);
		user.setSex(sex);
		user.setValidationstate(1);//设置用户的验证状态，1表示完善信息完毕，但未实名认证
		//以下为处理上传文件的代码
		if (!image.isEmpty()) {  
            try {  
                // 文件保存路径  
             /*   String filePath = request.getSession().getServletContext().getRealPath("/") + "fileupload/"  
                        + image.getOriginalFilename();  
                // 转存文件  
                image.transferTo(new File(filePath));  
                System.out.println("文件上传成功，路径是"+filePath);
                user.setImage(filePath);//图片信息入库
                request.getSession().setAttribute("filepath", filePath);*/
            	//2016.0408晚第二次实现图片上传代码
            	String pathRoot = request.getSession().getServletContext().getContextPath();//获取物理路径webapp所在路径
            	String path="";  
            	
            	String savepath  = request.getSession().getServletContext().getRealPath("/");
            	            	
            	if(!image.isEmpty()){
            		//生成uuid作为文件名称
            		String uuid = UUID.randomUUID().toString().replace("-", "");
            		 
            		//获得文件类型，用于过滤和判断，现在先不做了
            	    String contentType=image.getContentType();  
            	    String imageName=contentType.substring(contentType.indexOf("/")+1); 
            	    path="/fileupload/"+uuid+"."+imageName;  
            		String imagePath = uuid+"."+imageName;  //这是用于显示到前台的名称
            	    image.transferTo(new File(savepath+path));  
            		
            		user.setImage(path);//入库
            		request.getSession().setAttribute("imagePath", imagePath);
            		System.out.println("老子想看看图片的路径：："+pathRoot + "  名称： "+ path);
            	}
            	
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
		userService.updateUser(user);		
		
		request.getSession().removeAttribute("user");
		request.getSession().setAttribute("user", user);
				
		
		return "index";
			
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
		return "index";
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
	public String MyInfo() {
		return "jsp/manager1";
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
	
	
}

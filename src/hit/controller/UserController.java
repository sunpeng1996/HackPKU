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

import java.io.UnsupportedEncodingException;
import java.sql.Time;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			
			//调用创建用户的方法
			String flag = userService.addUser(user);	
			request.getSession().setAttribute("user", user);//将用户放入到session域中
			if (flag.equals("success")) {
				return "jsp/manager";
			}
			return "";		
	}
	
	/**
	 * 更新用户信息
	 * @author sunpeng123
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/user_update.do",method={RequestMethod.POST})
	public String update(HttpServletRequest request,@RequestParam String username,
			@RequestParam String schoolname,@RequestParam String institute,@RequestParam String major,
			@RequestParam String time,@RequestParam String phone,@RequestParam String sex,
			@RequestParam String province) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("当前用户是"+user.getEmail());
		Integer id = user.getUserId();
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
			schoolMapper.insert(temp);//持久化到数据库中			
			temp.setSchoolname(schoolname);			
			Integer tempid = schoolService.selectSchidBySchoolName(temp.getSchoolname());
			user.setSchool(temp);
			user.setSchId(tempid);			
		}		else {
			user.setSchool(school);
			user.setSchId(schid);
		}
	
		user.setMajor(major);
		user.setInstitute(institute);
		user.setTime(time);
		user.setSex(sex);
		request.getSession().setAttribute("user", user);
		
		userService.updateUser(user);
		
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
		
		return "index";
	}
	
	
}

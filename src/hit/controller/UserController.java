package hit.controller;
/**
 * 用户模块控制器
 */
import hit.po.User;
import hit.service.UserService;

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

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}

	/*@RequestMapping(value="/login.do",method = { RequestMethod.GET, RequestMethod.POST })
	public String login(){
			
	}*/
	
	@RequestMapping(value="/user_regist.do",method={RequestMethod.POST})
	public String regist(HttpServletRequest request , @RequestParam String email ,@RequestParam String password ){
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			
			//调用创建用户的方法
			String flag = userService.addUser(user);	
			request.getSession().setAttribute("user", user);//将用户放入到session域中
			if (flag.equals("success")) {
				return "manager";
			}
			return "";		
	}
	
	/**
	 * 更新用户信息
	 * @param request
	 * @param username
	 * @param school
	 * @param institute
	 * @param major
	 * @param time
	 * @param phone
	 * @param sex
	 * @param province
	 * @return
	 */
	@RequestMapping(value="/user_update.do",method={RequestMethod.POST})
	public String update(HttpServletRequest request,@RequestParam String username,
			@RequestParam String school,@RequestParam String institute,@RequestParam String major,
			@RequestParam String time,@RequestParam String phone,@RequestParam String sex,
			@RequestParam String province){
		
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("当前用户是"+user.getEmail());
		user.setPhone(phone);
		user.setProvince(province);
		user.setUsername(username);
		//user.setSchId(schId);
		user.setMajor(major);
		user.setInstitute(institute);
		user.setTime(time);
		user.setSex(sex);
	
		request.getSession().setAttribute("user", user);
		
		userService.updateUser(user);
		
		return "index";
			
	}
	
	
	
}

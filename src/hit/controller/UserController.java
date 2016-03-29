package hit.controller;
/**
 * 用户模块控制器
 */
import hit.po.User;
import hit.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class UserController extends AbstractController {
	
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
			User temp = userService.selectByEmail(email);
			//未完待续
			
			
			return password;
		
	}
	
}

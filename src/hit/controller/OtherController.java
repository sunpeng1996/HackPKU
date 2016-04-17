package hit.controller;

import hit.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class OtherController extends AbstractController {
	
	@Autowired
	private UserService userService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:转发到认证视图
	 *创建时间:2016年4月17日下午12:05:10
	 */
	@RequestMapping(value="/confirm.do",method={RequestMethod.GET})
	public String confirm() {
		return "jsp/confirm";
	}
	
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:跳转到找回密码的界面
	 *创建时间:2016年4月17日下午12:34:18
	 */
	@RequestMapping(value="/forgetPassword.do")
	public String forgetPassword() {
		return "jsp/findUserPassword";
	}
	
	/**
	 * @author 作者: 如今我已·剑指天涯
	 * @Description：这是通过邮箱找回密码的方法
	 *创建时间:2016年4月17日下午12:34:48
	 */
	@RequestMapping(value="/findPasswordByEmail.do")
	public @ResponseBody String findPasswordByEmail(HttpServletRequest request,
			@RequestParam(defaultValue="") String email) {
		Boolean flag = false;
		flag = userService.findPasswordByEmail(email);
		if(flag==true){
			System.out.println("找回密码的邮件已经发送了");
			return "success";
		}else {
			return "error";
		}
	}
}

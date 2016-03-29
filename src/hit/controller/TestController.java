package hit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class TestController extends AbstractController {

	@Override
	@RequestMapping(value="/hello.do")
	/*@requestMapping注解必须要加，作用：
	1、对url和Handler的方法进行映射。
	2、可以窄化请求映射，设置Handler的根路径，url就是根路径+子路径请求方式
	3、可以限制http请求的方法
	映射成功后，springmvc框架生成一个Handler对象，对象中只包括 一个映射成功的method。*/
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			System.out.println("hello sunpeng");
		return new ModelAndView("hello");
	}

}

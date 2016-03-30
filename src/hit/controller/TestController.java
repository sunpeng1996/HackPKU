package hit.controller;

import hit.mapper.UserMapper;
import hit.po.User;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
public class TestController extends AbstractController {
	/*@Autowired
	private UserService userService;*/
	@Autowired
	private UserMapper userMapper;
	
	SqlSessionFactory sqlSessionFactory;

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
	
	  @Before
	     public void initFactory() throws IOException
	     {
	         String resource = "sqlMapConfig.xml";
	
	         InputStream inputStream = Resources.getResourceAsStream(resource);
	
	         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    }
	
	@SuppressWarnings("resource")
	@Test
	public void testFindUserByKey(){
		//String key = "233333333@qq.com";
		//User user = userService.selectByEmail(email);
	/*	SqlSession session=sqlSessionFactory.openSession();
	 * User user = session.selectOne("hit.mapper.UserMapper.selectByPrimaryKey",1);*/
		ApplicationContext ctx=null;  
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
        UserMapper userMapper=(UserMapper)ctx.getBean("userMapper");  
		User user = userMapper.selectByPrimaryKey(1);
		if(user!=null){
			System.out.println(user.getUsername());
			System.out.println("该邮箱已经被注册");
		}else{
			System.out.println("adaada ");
		}
	}

}

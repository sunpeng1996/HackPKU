package hit.controller;

import hit.po.News;
import hit.po.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author sunpeng123
 * 这是新闻模块控制器
 */
@Controller
public class NewsController  {
	
	/**
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:去往写新闻的页面
	 *创建时间:2016年4月17日下午8:43:42
	 */
	@RequestMapping(value="/toPublishNews.do")
	public String toWriteClubNews() {
		return "jsp/publishNews";
	}
	
	
	
	/**
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:前往删除日志的界面
	 *创建时间:2016年4月18日下午8:45:43
	 */
	@RequestMapping(value="/toDeleteNews.do")
	public String toDeleteNews(){
		return "jsp/deleteNews";
	}

	

}

package hit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hit.po.News;
import hit.po.NewsCustom;
import hit.po.User;
import hit.service.ClubService;
import hit.service.NewsService;
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

/**
 * @author sunpeng123
 * 这是新闻模块控制器
 */
@Controller
public class NewsController  {
	@Autowired
	private ClubService clubService;
   @Autowired
   private UserService userService;
   @Autowired
   private NewsService newsService;
	
	
	 //用来存储所有新闻的集合,用于显示到jsp上的
	   private List<NewsCustom> newsList = new ArrayList<NewsCustom>();
	   
	   private List<News> newsSimpleList = new ArrayList<News>();
	   
	   
	   private Integer user_id;
	   private Integer club_id;
	   private void loadIds(HttpServletRequest request){
		  
		   user_id = (Integer)request.getSession().getAttribute("user_id");
		   if (user_id == null) {
			   throw new RuntimeException("user_id不存在");
		   }
	   
		   club_id = (Integer)request.getSession().getAttribute("club_id");
		   if (club_id == null) {
			   throw new RuntimeException("user_id不存在");
		   }
	   }
	
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
	public String toDeleteNews(HttpServletRequest request){
		System.out.println("即将到达删除新闻的页面");
		loadIds(request);
		newsSimpleList = newsService.getAllNews(club_id);
		
		if(newsSimpleList.size()==0 || newsSimpleList==null){
			System.out.println("该社团已经没有新闻啦");
			request.setAttribute("error", "你的社团已经没有新闻啦，快去创建一个吧");
			return "jsp/error";
		}else{
		newsList.clear();//清空集合
		for( News news  : newsSimpleList){
				NewsCustom nc = new NewsCustom();//每遍历一次都创建一个NewsCustom
				nc.setAuthor(userService.getUserById(user_id).getUsername());
				nc.setClubId(news.getClubId());
				nc.setNewId(news.getNewId());
				nc.setTitle(news.getTitle());
				System.out.println(news.getSummary()+"我就想看看他是什么格式");
				nc.setNewsSummary(new String(news.getSummary()));//转换成string存储进去
				request.setAttribute("summary", news.getSummary());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String formatDate = format.format(news.getTime());
				nc.setNewsTime(formatDate);
				nc.setSummary(news.getSummary());
				nc.setPublisherId(user_id);
				
				newsList.add(nc);//这也添加了啊
		}
		request.removeAttribute("newsList");
		request.setAttribute("newsList", newsList);
		return "jsp/deleteCommunityNews";
		}
	}
	
	/**
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:删除新闻
	 *创建时间:2016年4月18日下午10:24:23
	 * @return
	 */
	@RequestMapping(value="/deleteNews.do",method={RequestMethod.POST})
	public @ResponseBody String deleteNews(HttpServletRequest request,Integer news_id) {
		System.out.println("这条新闻删除啦");
		 newsService.deleteByNewsId(news_id);
		 return "success";
	}

	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:前往编辑社团的界面
	 *创建时间:2016年4月18日下午10:25:05
	 */
	@RequestMapping(value="/toEditNews.do")
	public String toEditNews(HttpServletRequest request){
		System.out.println("即将到达删除新闻的页面");
		loadIds(request);
		newsSimpleList = newsService.getAllNews(club_id);
		if(newsSimpleList.size() == 0 || newsSimpleList == null){
			System.out.println("该社团已经没有新闻啦");
			request.setAttribute("error", "你的社团已经没有新闻啦，快去创建一个吧");
			return "jsp/error";
		}else{
		//newsList = null;
		newsList.clear();//清空集合
		for( News news  : newsSimpleList){
				NewsCustom nc = new NewsCustom();//每遍历一次都创建一个NewsCustom
				nc.setAuthor(userService.getUserById(user_id).getUsername());
				nc.setClubId(news.getClubId());
				nc.setNewId(news.getNewId());
				nc.setTitle(news.getTitle());
				System.out.println(news.getSummary()+"我就想看看他是什么格式");
				nc.setNewsSummary(new String(news.getSummary()));//转换成string存储进去
				request.setAttribute("summary", news.getSummary());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String formatDate = format.format(news.getTime());
				nc.setNewsTime(formatDate);
				nc.setSummary(news.getSummary());
				nc.setPublisherId(user_id);
				newsList.add(nc);//这也添加了啊
		}
		request.removeAttribute("newsList");
		request.setAttribute("newsList", newsList);
		return "jsp/editCommunityNews";
		}
	}
	
	/**
	 * @author sunpeng123
	 * 编辑新闻的方法
	 */
	@RequestMapping(value="/editNews.do",method={RequestMethod.POST})
	public  String editNews(HttpServletRequest request,Integer news_id){
			News news = newsService.getNewsById(news_id);
			request.setAttribute("summary", news.getSummary());
			request.setAttribute("news",news);//向request中存储数据用于数据回显
			return "jsp/publishNews";
	}

}

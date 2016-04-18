package hit.service;

import hit.po.News;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:
 *创建时间:2016年4月18日上午12:46:49
 */
@Component
public interface NewsService {

	List<News> getAllNews(Integer club_id);
	News getNewsById(Integer news_id);

	void deleteByNewsId(Integer news_id);
	
}

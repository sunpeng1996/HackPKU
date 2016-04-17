package hit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hit.mapper.NewsMapper;
import hit.po.News;
import hit.service.NewsService;
@Component
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public List<News> getAllNews(Integer club_id) {
		List<News> list = newsMapper.queryAllNews(club_id);
		if(list.size()>0 && list!=null && list.get(0)!=null){
			return list;
		}else {
			return null;
		}
		
	}

}

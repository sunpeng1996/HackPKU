package hit.mapper;

import java.util.List;

import hit.po.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

	List<News> queryAllNews(Integer club_id);
}
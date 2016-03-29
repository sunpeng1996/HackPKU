package hit.mapper;

import hit.po.School;

public interface SchoolMapper {
    int deleteByPrimaryKey(Integer schId);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer schId);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}
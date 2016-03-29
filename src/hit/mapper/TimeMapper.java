package hit.mapper;

import hit.po.Time;

public interface TimeMapper {
    int deleteByPrimaryKey(Integer timeId);

    int insert(Time record);

    int insertSelective(Time record);

    Time selectByPrimaryKey(Integer timeId);

    int updateByPrimaryKeySelective(Time record);

    int updateByPrimaryKey(Time record);
}
package hit.mapper;

import hit.po.Task;

public interface TaskMapper {
    int deleteByPrimaryKey(Integer taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}
package hit.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import hit.po.ClubMember;
import hit.po.EventPo;
import hit.po.Task;
import hit.po.TaskParticipator;
import hit.po.User;
import hit.service.UserService;
import hit.vo.EventVo;

public interface TaskMapper {
    int deleteByPrimaryKey(Integer taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
    
    List<Date> getDateWithTask(ClubMember clubMember);
    
    List<Date> getDateTaskAdmin(ClubMember clubMember);
    
    List<User> getTaskUsers(Integer task_id);
    
    List<EventPo> getUserTasks(ClubMember clubMember);
    
    List<EventPo> getUserTasksAdmin(ClubMember clubMember);
    
    List<EventPo> getClubTasks(Integer club_id);
    
    void addTaskParticiparors(TaskParticipator taskParticipator);
    
    void deleteTaskParticiparors(Integer task_id);
    
    void updateTaskScore(Map<String, Integer> usertaskMap);
    
    Integer getTaskTotalscore(Integer task_id);

    void toggleTaskTag(Integer task_id);
}
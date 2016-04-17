package hit.service;

import java.util.Date;
import java.util.List;

import hit.po.Club;
import hit.po.ClubMember;
import hit.po.ClubMemberRequest;
import hit.po.Menu;
import hit.po.Role;
import hit.po.RolePrivilege;
import hit.po.User;
import hit.service.exception.TaskException;
import hit.vo.EventVo;

import org.springframework.stereotype.Component;


@Component
public interface TaskService {
	void deleteTask(Integer task_id);
	
    List<Integer> getDateWithTask(Integer month,Integer user_id,Integer club_id);
    
    List<Integer> getDateTaskAdmin(Integer month,Integer user_id,Integer club_id);
    
    List<EventVo> getUserEvents(Integer month,Integer day,Integer user_id,Integer club_id);
    
    List<EventVo> getAdminEvents(Integer month,Integer day,Integer user_id,Integer club_id);
    
    Integer addTask(Integer club_id,Integer user_id,Integer[] memberIds,EventVo eventVo);
    
    List<EventVo> getAllTaskAdmin(Integer club_id,Integer user_id);
    
    List<User> getTaskPtcs(Integer task_id);
    
    void updateUserScores(Integer club_id,Integer task_id,Integer[] scores) throws TaskException;
    
}

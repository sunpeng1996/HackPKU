package hit.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.commons.lang.ObjectUtils.Null;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import hit.common.BaseDao;
import hit.mapper.ClubMapper;
import hit.mapper.MenuMapper;
import hit.mapper.RoleMapper;
import hit.mapper.TaskMapper;
import hit.po.Club;
import hit.po.ClubMember;
import hit.po.ClubMemberRequest;
import hit.po.EventPo;
import hit.po.Menu;
import hit.po.Role;
import hit.po.RolePrivilege;
import hit.po.Task;
import hit.po.TaskParticipator;
import hit.po.User;
import hit.service.ClubService;
import hit.service.TaskService;
import hit.service.exception.TaskException;
import hit.vo.EventVo;
@Component
public class TaskServiceImpl extends BaseDao implements TaskService {
		@Autowired
		private TaskMapper taskMapper;
		@Autowired
		private ClubMapper clubMapper;
		@Override
		public void deleteTask(Integer task_id) {
			taskMapper.deleteTaskParticiparors(task_id);
			taskMapper.deleteByPrimaryKey(task_id);
		}
		@Override
		public List<Integer> getDateWithTask(Integer month,Integer user_id, Integer club_id) {
			ClubMember clubMember = new ClubMember(user_id, club_id, 0);
			List<Date> dateList =  taskMapper.getDateWithTask(clubMember);
			SimpleDateFormat sFormat_day= new SimpleDateFormat("dd");
			SimpleDateFormat sFormat_month= new SimpleDateFormat("MM");
			List<Integer> days = new ArrayList<Integer>();
			for (Date date : dateList) {
				//把四月份的event-day 加入List
				if(month == Integer.parseInt(sFormat_month.format(date))){
					days.add(Integer.parseInt(sFormat_day.format(date)));					
				}
			}
			return days;
		}
		@Override
		public List<Integer> getDateTaskAdmin(Integer month, Integer user_id,Integer club_id) {
			ClubMember clubMember = new ClubMember(user_id, club_id, 0);
			List<Date> dateList =  taskMapper.getDateTaskAdmin(clubMember);
			SimpleDateFormat sFormat_day= new SimpleDateFormat("dd");
			SimpleDateFormat sFormat_month= new SimpleDateFormat("MM");
			List<Integer> days = new ArrayList<Integer>();
			for (Date date : dateList) {
				//把四月份的event-day 加入List
				if(month == Integer.parseInt(sFormat_month.format(date))){
					days.add(Integer.parseInt(sFormat_day.format(date)));					
				}
			}
			return days;
		}
		@Override
		public List<EventVo> getUserEvents(Integer month, Integer day,	Integer user_id, Integer club_id) {
			ClubMember clubMember = new ClubMember(user_id, club_id, 0);
			List<EventPo> tasks = taskMapper.getUserTasks(clubMember);
			SimpleDateFormat sFormat_day= new SimpleDateFormat("dd");
			SimpleDateFormat sFormat_month= new SimpleDateFormat("MM");
			SimpleDateFormat sFormat_hour= new SimpleDateFormat("HH");
			SimpleDateFormat sFormat_min= new SimpleDateFormat("mm");
			List<EventVo> eventVos = new ArrayList<EventVo>();
			for (EventPo eventPo : tasks) {
				Date date = eventPo.getTime_id_begin();
				//把指定日期的event加入List
				if(month == Integer.parseInt(sFormat_month.format(date)) && day == Integer.parseInt(sFormat_day.format(date))){
					EventVo eventVo = (EventVo)eventPo;
					//字段拼凑
					List<User> userList = taskMapper.getTaskUsers(eventPo.getTask_id());
					String members = getMembersByUserList(userList);
					eventVo.setMembers(members);
					eventVo.setStart_hour(sFormat_hour.format(eventPo.getTime_id_begin()));
					eventVo.setStart_min(sFormat_min.format(eventPo.getTime_id_begin()));
					eventVo.setEnd_hour(sFormat_hour.format(eventPo.getTime_id_end()));
					eventVo.setEnd_min(sFormat_min.format(eventPo.getTime_id_end()));
					eventVo.setThisDay(day.toString());
					//加入List
					eventVos.add(eventVo);
				}				
			}
			return eventVos;
		}
        @Override
        public List<EventVo> getAdminEvents(Integer month, Integer day,Integer user_id, Integer club_id) {
        	ClubMember clubMember = new ClubMember(user_id, club_id, 0);
			List<EventPo> tasks = taskMapper.getUserTasksAdmin(clubMember);
			SimpleDateFormat sFormat_day= new SimpleDateFormat("dd");
			SimpleDateFormat sFormat_month= new SimpleDateFormat("MM");
			SimpleDateFormat sFormat_hour= new SimpleDateFormat("HH");
			SimpleDateFormat sFormat_min= new SimpleDateFormat("mm");
			List<EventVo> eventVos = new ArrayList<EventVo>();
			for (EventPo eventPo : tasks) {
				Date date = eventPo.getTime_id_begin();
				//把指定日期的event加入List
				if(month == Integer.parseInt(sFormat_month.format(date)) && day == Integer.parseInt(sFormat_day.format(date))){
					EventVo eventVo = (EventVo)eventPo;
					//字段拼凑
					List<User> userList = taskMapper.getTaskUsers(eventPo.getTask_id());
					String members = getMembersByUserList(userList);
					eventVo.setMembers(members);
					eventVo.setStart_hour(sFormat_hour.format(eventPo.getTime_id_begin()));
					eventVo.setStart_min(sFormat_min.format(eventPo.getTime_id_begin()));
					eventVo.setEnd_hour(sFormat_hour.format(eventPo.getTime_id_end()));
					eventVo.setEnd_min(sFormat_min.format(eventPo.getTime_id_end()));
					eventVo.setThisDay(day.toString());
					//加入List
					eventVos.add(eventVo);
				}				
			}
			return eventVos;
        }
		private String getMembersByUserList(List<User> userList) {
			StringBuilder stringBuilder = new StringBuilder();
			for (User user : userList) {
				stringBuilder.append(user.getUsername());
				stringBuilder.append("、");
			}
			String string = stringBuilder.toString();
			return string.substring(0, string.length()==0? string.length():string.length()-1);
		}
		@Override
		public Integer addTask(Integer club_id, Integer user_id, Integer[] memberIds,	EventVo eventVo) {
				Task task = null;
				try {
					task = transEventVoIntoTask(eventVo);
				} catch (ParseException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
				task.setUserIdLeader(user_id);
				task.setClubId(club_id);
				task.setState(0);
				taskMapper.insert(task);
				//获取刚刚生成的自增长主键
				List<EventPo> eventPos = taskMapper.getClubTasks(club_id);
				int max_id = 0;
				for (EventPo eventPo : eventPos) {
					if(eventPo.getTask_id() > max_id){
						max_id = eventPo.getTask_id();
					}
				}
				//插入任务与用户关系
				if (memberIds.length > 0) {
					User user = new User();
					Task tempTask = new Task();
					tempTask.setTaskId(max_id);
					TaskParticipator taskParticipator = new TaskParticipator();
					taskParticipator.setTask(tempTask);
					
					for(Integer i:memberIds){
						user.setUserId(i);
						taskParticipator.setUser(user);
						taskMapper.addTaskParticiparors(taskParticipator);
					}
				}
				return max_id;
		}
		private Task transEventVoIntoTask(EventVo eventVo) throws ParseException{
			String[] datemes = eventVo.getThisDay().split("/");
			String day = datemes[0];
			String month = datemes[1];
			String year = datemes[2];
			String hourE = eventVo.getEnd_hour();
			String hourB = eventVo.getStart_hour();
			String minE = eventVo.getEnd_min();
			String minB = eventVo.getStart_min();
			day = formatDateString(day);
			month = formatDateString(month);
			hourE = formatDateString(hourE);
			hourB = formatDateString(hourB);
			minE = formatDateString(minE);
			minB = formatDateString(minB);
			Task task = new Task();
			task.setSummary(eventVo.getSummary());
			task.setTaskname(eventVo.getTaskname());
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmm") ;
			Date beginDate = sFormat.parse(year+month+day+hourB+minB);
			Date endDate =  sFormat.parse(year+month+day+hourE+minE);
			task.setTimeIdBegin(beginDate);
			task.setTimeIdEnd(endDate);
			if (!eventVo.getTotalscore().trim().isEmpty()&&eventVo.getTotalscore()!=null) {
				try {
					task.setTotalscore(Integer.parseInt(eventVo.getTotalscore()));		
				} catch (Exception e) {
					System.out.println("error parsrInt"+eventVo.getTotalscore());
				}		
			}
			
			return task;
		}
		@Override
		public List<EventVo> getAllTaskAdmin(Integer club_id, Integer user_id) {

        	ClubMember clubMember = new ClubMember(user_id, club_id, 0);
			List<EventPo> tasks = taskMapper.getUserTasksAdmin(clubMember);
			List<EventVo> events  = new ArrayList<EventVo>();
			for (EventPo eventPo : tasks) {
				events.add((EventVo)eventPo);			
			}
			return events;
		}
		private String formatDateString(String code) {
			if (code.length() == 1) {
				return "0" + code;
			}else{
				return code;
			}
		}
		@Override
		public List<User> getTaskPtcs(Integer task_id) {
			return taskMapper.getTaskUsers(task_id);
		}
		@Override
		public void updateUserScores(Integer club_id,Integer task_id, Integer[] scores) throws TaskException {
			Integer totalScore = 0;
			for (Integer integer : scores) {
				totalScore += integer;
			}
			if(taskMapper.getTaskTotalscore(task_id) != totalScore){
				throw new TaskException("总分值不对!");
			}
			
			//1、获取taskList的ptcs
			List<User> userList = taskMapper.getTaskUsers(task_id);
			//2、对于每个user在user_participator表中更新，同时对user的总分进行更新，发送提示邮件
			HashMap<String, Integer> usertaskMap = new HashMap<String,Integer>();
			usertaskMap.put("task_id", task_id);
			int index = 0;
			for (User user : userList) {
				ClubMember clubMember = new ClubMember(user.getUserId(), club_id, 0);
				clubMember.setScore(scores[index]);
				clubMapper.updateUserClubScore(clubMember);
				
				usertaskMap.put("score", scores[index]);
				usertaskMap.put("user_id", user.getUserId());
				taskMapper.updateTaskScore(usertaskMap);
				index++;
			}
			//3、将task的状态标为1
			taskMapper.toggleTaskTag(task_id);
		}
		
}

package hit.controller;
/**
 * 用户模块控制器
 */
import hit.mapper.ClubMapper;
import hit.mapper.RoleMapper;
import hit.po.Club;
import hit.po.ClubMember;
import hit.po.ClubMemberRequest;
import hit.po.Menu;
import hit.po.Role;
import hit.po.RolePrivilege;
import hit.po.User;
import hit.service.ClubService;
import hit.service.TaskService;
import hit.service.UserService;
import hit.vo.EventVo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TaskController{
	
	@Autowired
	private ClubService clubService;
   @Autowired
   private TaskService taskService;

   private Integer user_id;
   private Integer club_id;
   private void loadIds(HttpServletRequest request){
	   if (user_id == null) {
		   user_id = (Integer)request.getSession().getAttribute("user_id");
		   if (user_id == null) {
			   user_id = 3;
		   }
	   }
	   if (club_id == null) {
		   club_id = (Integer)request.getSession().getAttribute("club_id");
		   if (club_id == null) {
			   club_id = 1;
		   }
	   }
   }
   
   /**
    * @author sunyiyou
    * @param request
    * @param month_now
    * @return days(withTasks)
    */
   @RequestMapping(value="getDateList.do",method={RequestMethod.GET})
   public @ResponseBody  List<Integer> getDateList(HttpServletRequest request,Integer month_now){
	   loadIds(request);
	   List<Integer> days = taskService.getDateWithTask(month_now,user_id,club_id);
	   return days;
   }
   /**
    * @author sunyiyou
    * @param request
    * @param month_now
    * @return days(withTasks)
    */
   @RequestMapping(value="addTask.do",method={RequestMethod.GET})
   public  @ResponseBody Integer addTask(HttpServletRequest request, @RequestParam(value = "memberIds[]") Integer[] memberIds ,EventVo eventVo){
	   loadIds(request);
	   System.out.println(memberIds);
	   System.out.println(eventVo);
	   return  taskService.addTask(club_id, user_id, memberIds, eventVo);
   }
   /**
    * @author sunyiyou
    * @param request
    * @param month_now
    * @return days(withTasks)
    */
   @RequestMapping(value="deleteTask.do",method={RequestMethod.GET})
   public  @ResponseBody Integer deleteTask(HttpServletRequest request, Integer data_id){
	   loadIds(request);
	   taskService.deleteTask(data_id);
	   return  data_id;
   }
   /**
    * @author sunyiyou
    * @param request
    * @param month_now
    * @return days(Admin distribute)
    */
   @RequestMapping(value="getDateListAdmin.do",method={RequestMethod.GET})
   public @ResponseBody  List<Integer> getDateListAdmin(HttpServletRequest request,Integer month_now){
	   loadIds(request);
	   List<Integer> days = taskService.getDateTaskAdmin(month_now,user_id,club_id);
	   return days;
   }
   /**
    * @author sunyiyou
    * @param request
    * @param month_now
    * @param day_now
    * @return events(per day)
    */
   @RequestMapping(value="getUserEventPerDay.do",method={RequestMethod.GET})
   public @ResponseBody  List<EventVo> getUserEventPerDay(HttpServletRequest request,Integer month_now,Integer day_now){
	   List<EventVo> events = taskService.getUserEvents(month_now, day_now, user_id, club_id);
	   return events;
   }
   /**
    * @author sunyiyou
    * @param request
    * @param month_now
    * @param day_now
    * @return events(per day)
    */
   @RequestMapping(value="getAdminTaskPerDay.do",method={RequestMethod.GET})
   public @ResponseBody  List<EventVo> getAdminTaskPerDay(HttpServletRequest request,Integer month_now,String day_now){
	   List<EventVo> events = taskService.getAdminEvents(month_now, Integer.parseInt(day_now), user_id, club_id);
	   return events;
   }
   /**
    * @author sunyiyou
    * @param request
    * @return scheduel.jsp
    */
   @RequestMapping(value="scheduel.do",method={RequestMethod.GET})
   public String scheduel(HttpServletRequest request){
	   return "scheduel";
   }
   /**
    * @author sunyiyou
    * @param request
    * @return distributeactivity.jsp
    */
   @RequestMapping(value="distributeactivity.do",method={RequestMethod.GET})
   public String distributeactivity(HttpServletRequest request){
	   loadIds(request);
	   request.setAttribute("clubMembership", clubService.getMembershipByClubId(club_id));
	   return "distributeactivity";
   }
   /**
    * @author sunyiyou
    * @param request
    * @return distributeactivity.jsp
    */
   @RequestMapping(value="editactivity.do",method={RequestMethod.GET})
   public String editactivity(HttpServletRequest request){
	   loadIds(request);
	   
	   return "editactivity";
   }

	
}

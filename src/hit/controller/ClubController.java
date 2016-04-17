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
import hit.service.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
@Controller
public class ClubController{
	
	@Autowired
	private ClubService clubService;
   @Autowired
   private UserService userService;


   //用来存储用户所加入的俱乐部
   private List<Club> clubs = new ArrayList<Club>();

   private Integer user_id;
   private Integer club_id;
   private void loadIds(HttpServletRequest request){
	  
	   user_id = (Integer)request.getSession().getAttribute("user_id");
	   if (user_id == null) {
		   throw new RuntimeException("user_id不存在");
	   }
   
	   club_id = (Integer)request.getSession().getAttribute("club_id");
	   if (club_id == null) {
		   throw new RuntimeException("user_id不存在");
	   }
   }
   
	/**
	 * 
	 * @author sunyiyou
	 * @param request
	 * @return "clubmessage"
	 * 点击社团信息，获取社团的基本信息，显示至clubmessage.jsp页面
	 */
	@RequestMapping(value="/clubmessage.do",method={RequestMethod.GET})
	public String showClubMessage(HttpServletRequest request){
		loadIds(request);
	   Club club = clubService.getClubById(club_id);
	   request.setAttribute("club", club);
	   User user = userService.getUserById(club.getUserIdLeader());
	   request.setAttribute("leadername", user.getUsername());
	   Date setuptimeDate =  club.getSetuptime();
	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
	   request.setAttribute("setupdate", simpleDateFormat.format(setuptimeDate));
		return "jsp/clubmessage";		
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return clubmembership
	 * 点击社团成员，获取社团成员列表以及他们的职位，显示在clubmembership页面
	 * 
	 */
	@RequestMapping(value="/clubmember.do",method={RequestMethod.GET})
	public String showClubMembership(HttpServletRequest request ,
			@RequestParam(defaultValue = "0") Integer club_id
	){
		List<ClubMember> clubMembership = clubService.getMembershipByClubId((Integer)request.getSession().getAttribute("club_id"));
		request.setAttribute("clubMembership", clubMembership);
		
		return "jsp/clubmember";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return clubmessage
	 * 编辑社团信息
	 */
	@RequestMapping(value="/editclubmessage.do",method={RequestMethod.GET})
	public String editClubMessage(HttpServletRequest request ,@RequestParam(defaultValue = "0") Integer club_id	){
//		   Club club = clubService.getClubById((Integer)request.getSession().getAttribute("club_id"));
		loadIds(request);
		Club club = clubService.getClubById(this.club_id);
		   request.setAttribute("club", club);
//		   User user = userService.getUserById(club.getUserIdLeader());
//		   request.setAttribute("leadername", user.getUsername());
//		   Date setuptimeDate =  club.getSetuptime();
//		   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
//		   request.setAttribute("setupdate", simpleDateFormat.format(setuptimeDate));
		return "jsp/editclubmessage";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club
	 * @param leadername
	 * @return clubmessage
	 * 更新社团信息
	 */
	@RequestMapping(value="/jsp/updateClubMessage.do",method={RequestMethod.POST})
	public  String updateClubMessage(HttpServletRequest request,Club club	){
		clubService.updateClub(club);		
		   request.setAttribute("club", club);
		return "jsp/editclubmessage";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return adjustclubrole
	 * 显示该社团所有的职位，并编辑他们的权限
	 */
	@RequestMapping(value="showRoles.do",method={RequestMethod.GET})
	public String showRoles(HttpServletRequest request	){
		loadIds(request);
		List<Menu> menus = clubService.getAlMenus();
		List<Role> roles = clubService.getRoles(club_id);
		request.getSession().setAttribute("menus", menus);
		request.setAttribute("roles", roles);
		return "jsp/adjustclubrole";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return adjustclubrole
	 * 添加角色，以及他所拥有的权限
	 */
	@RequestMapping(value="addRoles.do",method={RequestMethod.POST})
	public String addRoles(HttpServletRequest request ,
			@RequestParam(defaultValue = "12") String[] menu_ids,
			Role role
	){
		loadIds(request);
		role.setClubId(club_id);
		clubService.addRole(role);
		List<Role> roles = clubService.getRoles(club_id);
		request.setAttribute("roles", roles);
		int max_id = 0;
		for (Role r : roles) {
			if (r.getRoleId() > max_id) {
				max_id = r.getRoleId();
			}
		}		
		List<RolePrivilege> roleprivileges = new ArrayList<RolePrivilege>();
		for (String string : menu_ids) {
			Integer menu_id = Integer.parseInt(string);
			roleprivileges.add(new RolePrivilege(menu_id,max_id));
		}
		clubService.addRolePrivileges(roleprivileges);
		return "jsp/adjustclubrole";
	}

	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return updateRole
	 * 显示角色以及他的权限
	 */
	@RequestMapping(value="getRoleMenu.do",method={RequestMethod.POST})
	public @ResponseBody List<Integer> getRoleMenu(HttpServletRequest request,Role role){
		return clubService.getRoleMenu(role.getRoleId());
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param club_id
	 * @return updateRole
	 * 更新角色以及他的权限
	 */
	@RequestMapping(value="updateRole.do",method={RequestMethod.POST})
	public String updateRole(HttpServletRequest request,Role role ,@RequestParam(defaultValue = "12") String[] menu_ids){
//		Integer club_id = (Integer)request.getSession().getAttribute("club_id");
		loadIds(request);
		if (role.getRoleId() == null) {
			//add
			role.setClubId(club_id);
			clubService.addRole(role);
			List<Role> roles = clubService.getRoles(club_id);
			request.setAttribute("roles", roles);
			int max_id = 0;
			for (Role r : roles) {
				if (r.getRoleId() > max_id) {
					max_id = r.getRoleId();
				}
			}
			List<RolePrivilege> roleprivileges = new ArrayList<RolePrivilege>();
			for (String string : menu_ids) {
				Integer menu_id = Integer.parseInt(string);
				roleprivileges.add(new RolePrivilege(menu_id,max_id));
			}
			clubService.addRolePrivileges(roleprivileges);
		}else{
			//update
			role.setClubId(club_id);
			List<RolePrivilege> roleprivileges = new ArrayList<RolePrivilege>();
			for (String string : menu_ids) {
				Integer menu_id = Integer.parseInt(string);
				roleprivileges.add(new RolePrivilege(menu_id,role.getRoleId()));
			}
			clubService.updateRole(role, roleprivileges);			
		}
		List<Menu> menus = clubService.getAlMenus();
		List<Role> roles = clubService.getRoles(club_id);
		request.getSession().setAttribute("menus", menus);
		request.setAttribute("roles", roles);
		return "jsp/adjustclubrole";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param role
	 * @param menu_ids
	 * @return adjustclubrole
	 * 删除角色功能,及其权限
	 */
	@RequestMapping(value="deleteRole.do",method={RequestMethod.GET})
	public String deleteRole(HttpServletRequest request,Role role){
		clubService.deleteRole(role, (Integer)request.getSession().getAttribute("club_id"));
		List<Role> roles = clubService.getRoles((Integer)request.getSession().getAttribute("club_id"));
		request.setAttribute("roles", roles);
		return "jsp/adjustclubrole";
	}
	
	
	@RequestMapping(value="clubnews.do",method={RequestMethod.GET})
	public String clubnews(HttpServletRequest request){
		return "jsp/clubnews";
	}
	
	/**
	 * @author sunyiyou
	 * @param request
	 * @param role
	 * @return forward: delegateclubrole
	 * 分配用户角色
	 */
	@RequestMapping(value="/delegateclubrole.do",method={RequestMethod.GET})
	public String delegateclubrole(HttpServletRequest request,Role role){
//		Integer club_id = (Integer)request.getSession().getAttribute("club_id");

		loadIds(request);
		List<Role> roles = clubService.getRoles(club_id);
		request.setAttribute("roles",roles);
		List<ClubMember> clubmembers = clubService.getClubMembership(club_id);
		request.setAttribute("clubmembers", clubmembers);
		return "jsp/delegateclubrole";
	}
	/**
	 * @author sunyiyou
	 * @param request
	 * @param role
	 * @return delegateclubrole
	 * 编辑用户角色
	 */
	@RequestMapping(value="/editUserRole.do",method={RequestMethod.GET})
	public String editUserRole(HttpServletRequest request,
			@RequestParam(defaultValue="0") Integer roleId,
			@RequestParam(defaultValue="userId") Integer userId){
//		Integer club_id = (Integer)request.getSession().getAttribute("club_id");

		loadIds(request);
		clubService.editUserRole(userId, club_id, roleId);
		List<Role> roles = clubService.getRoles(club_id);
		request.setAttribute("roles",roles);
		List<ClubMember> clubmembers = clubService.getClubMembership(club_id);
		request.setAttribute("clubmembers", clubmembers);
		return "jsp/delegateclubrole";
	}

	
	/**
	 * @author sunyiyou
	 * @param request
	 * @return adjustclubmember
	 * 社团成员调整页面
	 */
	@RequestMapping(value="adjustclubmember.do",method={RequestMethod.GET})
	public String adjustclubmember(HttpServletRequest request){		
//		Integer club_id = (Integer)request.getSession().getAttribute("club_id");

		loadIds(request);
		//show roles
		List<Role> roles = clubService.getRoles(club_id);
		request.setAttribute("roles",roles);
		//show members
		List<ClubMember> clubMembership = clubService.getMembershipByClubId(club_id);
		request.setAttribute("clubMembership", clubMembership);
		//show requests
		List<ClubMemberRequest> requests = clubService.getClubMemberRequest(club_id);
		request.setAttribute("requests", requests);
		return "jsp/adjustclubmember";
	}
	
	/**
	 * @author sunyiyou
	 * @param request
	 * @return adjustclubmember
	 * 剔除社团成员
	 */
	@RequestMapping(value="kickClubMember.do",method={RequestMethod.GET})
	public String kickClubMember(HttpServletRequest request
			,@RequestParam(defaultValue="0") Integer userId
			,@RequestParam(defaultValue="0") Integer roleId){

		loadIds(request);
		Integer clubId = club_id;
		clubService.deleteClubMember(userId, clubId, roleId);
		
		//show roles
		List<Role> roles = clubService.getRoles(clubId);
		request.setAttribute("roles",roles);
		//show members
		List<ClubMember> clubMembership = clubService.getMembershipByClubId(clubId);
		request.setAttribute("clubMembership", clubMembership);
		//show requests
		List<ClubMemberRequest> requests = clubService.getClubMemberRequest(clubId);
		request.setAttribute("requests", requests);
		return "jsp/adjustclubmember" ;
	}
	
	@RequestMapping(value="addClubMember.do",method={RequestMethod.POST})
	public @ResponseBody String addClubMember(HttpServletRequest request
			,@RequestParam(defaultValue="0") Integer userId
			,@RequestParam(defaultValue="0") Integer roleId){
//		Integer clubId = (Integer)request.getSession().getAttribute("club_id");

		loadIds(request);
		Integer clubId = club_id;
		clubService.addClubMember(userId, clubId, roleId);
		//show roles
		List<Role> roles = clubService.getRoles(clubId);
		request.setAttribute("roles",roles);
		//show members
		List<ClubMember> clubMembership = clubService.getMembershipByClubId(clubId);
		request.setAttribute("clubMembership", clubMembership);
		//show requests
		List<ClubMemberRequest> requests = clubService.getClubMemberRequest(clubId);
		request.setAttribute("requests", requests);
		return "success";
	}
	@RequestMapping(value="rejectRequest.do",method={RequestMethod.POST})
	public @ResponseBody String rejectRequest(HttpServletRequest request
			,@RequestParam(defaultValue="0") Integer userId
			,@RequestParam(defaultValue="0") Integer roleId){
		clubService.rejectRequest(userId, club_id);		
		 return "success";
	}
	@RequestMapping(value="calcTotalRequest.do",method={RequestMethod.POST})
	public @ResponseBody String calcTotalRequest(HttpServletRequest request){
		loadIds(request);
		return clubService.calcTotalRequest(club_id) + "";
	}
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:获取所有的社团，用于用户加入社团
	 *创建时间:2016年4月16日下午7:11:09
	 */
	@RequestMapping(value="/getAllClubs.do")
	public String getAllClubs(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		List<Club> clubs = clubService.getAllClubs();
		request.getSession().setAttribute("clubs", clubs);
		return "jsp/toJoinClub";
	}
	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:
	TODO：toCreateCommunity
	 *创建时间:2016年4月16日上午9:43:21
	 * @return
	 */
	@RequestMapping(value="/toCreateCommunity.do")
	public String toCreateCommunity() {
		return "jsp/creatCommunity";
	}

	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:
	TODO创建社团
	 *创建时间:2016年4月16日上午8:52:14
	 * @return
	 */
	@RequestMapping(value="/club_create.do",method={RequestMethod.POST})
	public   @ResponseBody String club_create(HttpServletRequest request,
			@RequestParam(defaultValue="") String clubname,
			@RequestParam(defaultValue="") String description,
			@RequestParam(defaultValue="") Date setuptime,
			@RequestParam(value = "clubImage", required = false) MultipartFile clubImage) {		
		Club club = new Club();		
		User user = (User) request.getSession().getAttribute("user");		
		Club club2 = clubService.createClub(request,club,clubname,description,setuptime,user, clubImage);
		Integer clubId = clubService.queryClubidByClubnameAndUserId(club2.getClubname(),user.getUserId());
		club2.setClubId(clubId);//id设置进去
		//System.out.println("这把让我看看id,老铁+"+ clubId);
		clubs.add(club2);
		request.getSession().setAttribute("clubs", clubs);
		request.getSession().setAttribute("user_id", user.getUserId());
		//调用service层绑定user和Club的方法
		clubService.bindUserAndClub(club2,user);
	
		return "successCreate";
	}
	
}

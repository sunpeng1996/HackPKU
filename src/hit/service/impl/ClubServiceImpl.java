package hit.service.impl;

import hit.common.BaseDao;
import hit.mapper.ClubMapper;
import hit.mapper.MenuMapper;
import hit.mapper.RoleMapper;
import hit.po.Club;
import hit.po.ClubMember;
import hit.po.ClubMemberRequest;
import hit.po.Menu;
import hit.po.Role;
import hit.po.RolePrivilege;
import hit.po.User;
import hit.service.ClubService;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class ClubServiceImpl extends BaseDao implements ClubService {
		@Autowired
		private ClubMapper clubMapper;
		@Autowired
		private MenuMapper menuMapper;
		@Autowired
		private RoleMapper roleMapper;
		@Override
	    public Club getClubById(Integer club_id) {
			return clubMapper.selectByPrimaryKey(club_id);
		}
	  @Override
		public List<ClubMember> getMembershipByClubId(Integer club_id) {
		  	return clubMapper.getMembershipByClubId(club_id);
		}
	  @Override
	public void updateClub(Club club) {
	       clubMapper.updateByPrimaryKeySelective(club);
	}
	  @Override
	public List<Role> getRoles(Integer club_id) {
	      return clubMapper.getRolesByClubId(club_id);
	}
	  @Override
	public List<Menu> getAlMenus() {
		  return menuMapper.getAllMenus();
	}
	  @Override
	public int addRole(Role role) {
		 return  roleMapper.insert(role);
	}
	  @Override
	public List<Integer> getRoleMenu(Integer roleId) {		  
		  return clubMapper.getRoleMenu(roleId);
	}
	  @Override
	public void addRolePrivileges(List<RolePrivilege> rolePrivileges) {
		  for (RolePrivilege rolePrivilege : rolePrivileges) {
	           menuMapper.addRolePrivilege(rolePrivilege);
		}
	}
	  @Override
	public void updateRole(Role role,List<RolePrivilege> rolePrivileges) {
		  menuMapper.deletePrivilegesByRoleId(role.getRoleId());
		  roleMapper.updateByPrimaryKeySelective(role);
		  this.addRolePrivileges(rolePrivileges);
	}
	  @Override
	public void deleteRole(Role role,Integer club_id) {
		  Role role_valid = roleMapper.selectByPrimaryKey(role.getRoleId());
			if (role_valid.getClubId() == club_id) {
				  menuMapper.deletePrivilegesByRoleId(role.getRoleId());
				  roleMapper.deleteByPrimaryKey(role.getRoleId());
			}else {
				throw new RuntimeException("不要行使超出你权职的职能");
			}
	}
	  @Override
	public List<ClubMember> getClubMembership(Integer club_id) {
		  return clubMapper.getMembershipByClubId(club_id);
	}
	  @Override
	public List<ClubMemberRequest> getClubMemberRequest(Integer club_id) {
		  return clubMapper.getMemberRequestByClubId(club_id);
	}
	  @Override
	public void editUserRole(Integer user_id, Integer club_id,Integer role_id) {
		  ClubMember clubMember = new ClubMember(user_id, club_id, role_id);
		  clubMapper.deleteClubMember(clubMember);
		  clubMapper.addClubMember(clubMember);
	}
   @Override
	public void deleteClubMember(Integer user_id, Integer club_id,Integer role_id) {
		  clubMapper.deleteClubMember(new ClubMember(user_id, club_id, role_id));	
	}
   @Override
	public void addClubMember(Integer user_id, Integer club_id, Integer role_id) {
		  ClubMember clubMember = new ClubMember(user_id, club_id, role_id);
		  clubMapper.addClubMember(clubMember);
		  clubMapper.deleteClubRequest(clubMember);
		  //send agree email
	}
   @Override
	public Role getUserRoleInClub(Integer userId, Integer clubId) {
	      return clubMapper.getUserRoleInClub(new ClubMember(userId, clubId, 0));
	}
   @Override
	public List<Club> getClubsByUser(Integer user_id) {
	     return clubMapper.getClubsByUser(user_id);
	}
   @Override
   public void rejectRequest(Integer user_id, Integer club_id) {
		  ClubMember clubMember = new ClubMember(user_id, club_id, 0);
		  clubMapper.deleteClubRequest(clubMember);
		  //send reject email
   }
   @Override
	public Integer calcTotalRequest(Integer club_id) {
		return clubMapper.calcTotalRequest(club_id);
   }
   
	@Override
	/**
	 * @author sunpeng123
	 * queryClubidByClubnameAndUserId
	 */
	public Integer queryClubidByClubnameAndUserId(String clubname, Integer userId) {
		Map map = new HashMap();
		map.put("clubname", clubname);
		map.put("userId", userId);
		List list = getSqlMapClientTemplate().queryForList("queryClubidByClubnameAndUserId", map);
		if (list.size() == 0 || list == null) {
			return null;
		} else {
			return (Integer)list.get(0);
		}
	}
	

@Override
/**
 * @author sunpeng123
 * 创建社团方法
 */
		public Club createClub(HttpServletRequest request,Club club,String clubname, String description, Date setuptime,
				User user, MultipartFile clubImage) {
			club.setClubname(clubname);
			club.setDescription(description);
			club.setSetuptime(setuptime);
			club.setUserIdLeader(user.getUserId());
			club.setValidationstate(0);//社团创建之初未验证，设为0
			
			//以下为处理上传文件的代码
			if (!clubImage.isEmpty()) {  
	            try {  
	            	String pathRoot = request.getSession().getServletContext().getContextPath();//获取物理路径webapp所在路径
	            	String path="";  
	            	String savepath  = request.getSession().getServletContext().getRealPath("/");
	            	if(!clubImage.isEmpty()){
	            		//生成uuid作为文件名称
	            		String uuid = UUID.randomUUID().toString().replace("-", "");
	            		 
	            		//获得文件类型，用于过滤和判断，现在先不做了
	            	    String contentType=clubImage.getContentType();  
	            	    String imageName=contentType.substring(contentType.indexOf("/")+1); 
	            	    path="/fileupload/"+uuid+"."+imageName;  
	            		String imagePath = uuid+"."+imageName;  //这是用于显示到前台的名称
	            		clubImage.transferTo(new File(savepath+path));  
	            		club.setImage(imagePath);//入库
	            		request.getSession().setAttribute("clubImage", imagePath);
	            		System.out.println("老子想看看社团图片的路径：："+pathRoot + "  名称： "+ path);
	            	}
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }
			 clubMapper.insert(club);
			return club;
		}
	@Override
	/**
	 * @author sunpeng123
	 * 用户和社团的绑定方法，直接是主席，因为这社团是他创立的
	 */
	public void bindUserAndClub(Club club2, User user) {
		Role role  = new Role();
		role.setRolename("主席");
		role.setDescription("");
		role.setClubId(club2.getClubId());
		roleMapper.insert(role);//插入到数据库中
		
		Map map = new HashMap();
		map.put("rolename", "主席");
		map.put("club_id", club2.getClubId());
		
		List list = getSqlMapClientTemplate().queryForList("queryRoleidByRolenameAndClubname",map);
		if (list.size() == 0 || list == null) {
			System.out.println("错误，roleid为空");
		} else {
			Integer roleid = (Integer) list.get(0);
			addClubMember(user.getUserId(), club2.getClubId(), roleid);//增加用户成员
			List<RolePrivilege> rolePrivileges = new ArrayList<RolePrivilege>();
			List<Menu> menus = menuMapper.getAllMenus();
			for(Menu temp : menus){
				RolePrivilege rolePrivilege = new RolePrivilege(temp.getMenuId(), roleid);
				rolePrivileges.add(rolePrivilege);
			}
			this.addRolePrivileges(rolePrivileges);
		}
		
	}
   
   /**
	 * 获取所有的俱乐部
	 * @author sunpeng123
	 */

	@Override
	public List<Club> getAllClubs() {
		List<Club> clubs  = clubMapper.queryAllClubs();
		if (clubs.size() == 0 || clubs == null) {
			System.out.println("错误，clubs为空");
		} else {
			return clubs;
		}
		return null;
	}
}

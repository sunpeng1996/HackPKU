package hit.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
	}
   @Override
	public Role getUserRoleInClub(Integer userId, Integer clubId) {
	      return clubMapper.getUserRoleInClub(new ClubMember(userId, clubId, 0));
	}
   @Override
	public List<Club> getClubsByUser(Integer user_id) {
	     return clubMapper.getClubsByUser(user_id);
	}
}

package hit.service;

import java.util.List;

import hit.po.Club;
import hit.po.ClubMember;
import hit.po.ClubMemberRequest;
import hit.po.Menu;
import hit.po.Role;
import hit.po.RolePrivilege;
import hit.po.User;

import org.springframework.stereotype.Component;


@Component
public interface ClubService {
	public Club getClubById(Integer club_id) ;
	public List<ClubMember> getMembershipByClubId(Integer club_id);
	public void updateClub(Club club);
	public List<Role> getRoles(Integer club_id);
	public List<Menu> getAlMenus();
	public int addRole(Role role);
	public List<Integer> getRoleMenu(Integer roleId);
	public void addRolePrivileges(List<RolePrivilege> rolePrivileges);	
	public void updateRole(Role role,List<RolePrivilege> rolePrivileges) ;
	public void deleteRole(Role role,Integer club_id);
	public List<ClubMember> getClubMembership(Integer club_id);
	public List<ClubMemberRequest> getClubMemberRequest(Integer club_id);
	public void editUserRole(Integer user_id,Integer club_id,Integer role_id);
	public void deleteClubMember(Integer user_id,Integer club_id,Integer role_id);
	public void addClubMember(Integer user_id,Integer club_id,Integer role_id);
	public Role getUserRoleInClub(Integer userId,Integer clubId);
	public List<Club> getClubsByUser(Integer user_id);
}

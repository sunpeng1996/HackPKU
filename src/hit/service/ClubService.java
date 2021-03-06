package hit.service;

import hit.po.Club;
import hit.po.ClubMember;
import hit.po.ClubMemberRequest;
import hit.po.Menu;
import hit.po.News;
import hit.po.Role;
import hit.po.RolePrivilege;
import hit.po.User;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


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
	public void rejectRequest(Integer user_id,Integer club_id);
	public Integer calcTotalRequest(Integer club_id);
	
	public Club createClub(HttpServletRequest request, Club club, String clubname, String description, Date setuptime,
			User user, MultipartFile clubImage);
	public Integer queryClubidByClubnameAndUserId(String clubname,
			Integer userId);
	public void bindUserAndClub(Club club2, User user);
	public List<Club> getAllClubs();

	/**
	 * 
	 * @author 作者: 如今我已·剑指天涯
	 * @Description:发布新闻，新闻入库
	 *创建时间:2016年4月17日下午10:09:54
	 */
	public News addNews(String title, String blob, Integer user_id,
			Integer club_id);
	/**
	 * 通过一系列参数查询新闻id
	 * @author 作者: 如今我已·剑指天涯
	 *创建时间:2016年4月17日下午10:35:37
	 * @param date 
	 */
	public Integer queryNewsIdByTitleAndUser(String title, Integer user_id,
			Integer club_id);
}

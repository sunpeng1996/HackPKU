package hit.mapper;


import java.util.List;

import org.junit.Test;

import hit.po.Club;
import hit.po.ClubMember;
import hit.po.ClubMemberRequest;
import hit.po.Role;

public interface ClubMapper {
    int deleteByPrimaryKey(Integer clubId);

    int insert(Club record);

    int insertSelective(Club record);

    Club selectByPrimaryKey(Integer clubId);

    int updateByPrimaryKeySelective(Club record);

    int updateByPrimaryKey(Club record);
    
    List<Integer> getRoleMenu(Integer roleId);
    
    List<ClubMember> getMembershipByClubId(Integer club_id);

    List<ClubMemberRequest> getMemberRequestByClubId(Integer club_id);
    
    List<Role> getRolesByClubId(Integer club_id);
 
    void deleteClubMember(ClubMember clubMember);
    
    void addClubMember(ClubMember clubMember);
    
    void deleteClubRequest(ClubMember clubMember);
    
    Role getUserRoleInClub(ClubMember clubMember);
    
    List<Club> getClubsByUser(Integer userId);
    
    void updateUserClubScore(ClubMember clubMember);
    
    Integer calcTotalRequest(Integer club_id);
    
    /**
     * @author 作者: 如今我已·剑指天涯
     *创建时间:2016年4月16日下午8:00:42
     */
	List<Club> queryAllClubs();
    
}
package hit.mapper;

import java.util.List;

import hit.po.Menu;
import hit.po.RolePrivilege;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> getAllMenus();
    
    void addRolePrivilege(RolePrivilege rolePrivilege);
    
    void deletePrivilegesByRoleId(Integer role_id);
}
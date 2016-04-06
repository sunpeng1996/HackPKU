package hit.service.impl;
/**
 *service实现类
 */
import hit.common.BaseDao;
import hit.mapper.UserMapper;
import hit.po.School;
import hit.po.User;
import hit.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserServiceImpl extends BaseDao implements UserService {
	
	@Autowired 
	private UserMapper userMapper;
	
	
	@Override
	/**
	 * @author sunpeng123
	 * todo：根据email查询User对象
	 */
	public User selectByEmail(String email) {
		Map map = new HashMap();
		map.put("email", email);
		List list = getSqlMapClientTemplate().queryForList("selectByEmail", map);
		if (list.size() == 0 || list == null) {
			return null;
		} else {			
			return (User)list.get(0);
		}		
	}

	@SuppressWarnings("deprecation")
	@Override
	public String addUser(User user) {
		try {
			getSqlMapClientTemplate().insert("addUser", user);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	
/**
 * @author sunpeng123
 * 更新用户
 */
	@SuppressWarnings("deprecation")
	public void updateUser(User user) {
		try {
			
			getSqlMapClientTemplate().update("updateUser", user);
			System.out.println("正在更新用户："+user.getUsername());
			System.out.println(user.getUsername() + " 和  "+ user.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User login(String password, String email){
		Map map = new HashMap();
		map.put("email", email);
		map.put("password", password);
		List list = getSqlMapClientTemplate().queryForList("login", map);
		if (list.size() == 0 || list == null) {
			return null;
		} else {
			return (User)list.get(0);
		}
		
	}

	@Override
	/**
	 * @author sunpeng123
	 * todo:根据学校名称查询学习对象
	 */
	public School findSchoolBySchoolName(String schoolname) {
		try {
			List<School> schools = getSqlMapClientTemplate().queryForList("findSchoolBySchoolName", schoolname);
			if (schools.size()>0) {
				return (School)schools.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

}

	



	

	


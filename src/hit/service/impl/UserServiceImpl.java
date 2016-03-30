package hit.service.impl;
/**
 *service实现类
 */
import hit.common.BaseDao;
import hit.mapper.UserMapper;
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

	@SuppressWarnings("deprecation")
	public void updateUser(User user) {
		try {
			getSqlMapClientTemplate().insert("updateUser", user);
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



	

	
}

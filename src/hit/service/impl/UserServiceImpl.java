package hit.service.impl;
/**
 *service实现类
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hit.common.BaseDao;
import hit.po.User;
import hit.service.UserService;

public class UserServiceImpl extends BaseDao implements UserService {

	@Override
	public User login() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByEmail(String email) {
		Map map = new HashMap();
		map.put("EMAIL", email);
		List list = getSqlMapClientTemplate().queryForList("user", map);
		if (list.size() == 0 || list == null) {
			return null;
		} else {			
			return (User)list.get(0);
		}
		
	}
	
}
package hit.service.impl;
/**
 *service实现类
 */
import hit.common.BaseDao;
import hit.mapper.UserMapper;
import hit.po.School;
import hit.po.User;
import hit.service.UserService;
import hit.service.SchoolService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class schoolServiceImpl extends BaseDao implements SchoolService {
	
	@Autowired 
	private UserMapper userMapper;
	
	
	
	/**
	 * @author sunpeng123
	 * todo：根据schoolName查询schid
	 */	
	@Override
	public int selectSchidBySchoolName(String schoolname) {
		List list = getSqlMapClientTemplate().queryForList("selectSchidBySchoolName", schoolname);
		if (list.size()==0 || list == null) {
			return (Integer) null;
		}else {
			return (Integer) list.get(0);
		}
	}

	



	

	
}

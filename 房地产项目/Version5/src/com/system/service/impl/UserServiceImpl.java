package com.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.common.BaseDao;
import com.common.PageBean;
import com.common.Util;

@Component
//@Repository
public class UserServiceImpl extends BaseDao implements com.system.service.UserService {

	public PageBean createQueryPage(Map param) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append(" select q.*,w.rolename from t_user q left join t_role w on q.role_id=w.id where 1=1 ");
		if(!param.get("s_user_name").toString().equals("")){
			sql.append(" and q.username like '%" + param.get("s_user_name").toString() + "%' ");
		}
		sql.append("  order by w.id ");
		System.out.println(sql);
		List list = getSqlMapClientTemplate().queryForList("getAllUsers", Util.getPageSqlForMysql(sql.toString(),Integer.parseInt(param.get("pageSize").toString()),Integer.parseInt(param.get("currentPage").toString())));
		return Util.getPageBean(Integer.parseInt(param.get("pageSize").toString()),
				Integer.parseInt(param.get("currentPage").toString()), list, param,
				getSqlMapClientTemplate().queryForList("getAllUsers", sql.toString()).size());
	}

	public String addObject(Object obj) {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().insert("addUser", obj);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notOk";
		}
	}

	public Object findObjectById(int id) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForObject("findUserById", id);
	}

	@Transactional
	public String updateObject(Object obj) {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().update("updateUser", obj);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notOk";
		}
	}

	@Transactional
	public String deleteObject(String id) {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().delete("deleteUser", id);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notOk";
		}
	}

	public List getRoleForSelect() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getRoleForSelect");
	}

	public String searchYhm(String login_name) {
		// TODO Auto-generated method stub
		List list = getSqlMapClientTemplate().queryForList("searchYhm",login_name);
		return list.size() == 0 ? "y" : "n";
	}

}

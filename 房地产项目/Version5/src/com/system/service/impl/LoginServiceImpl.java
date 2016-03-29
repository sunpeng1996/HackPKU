package com.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.common.BaseDao;
import com.common.PageBean;
import com.common.Util;
import com.system.vo.User;

@Component
public class LoginServiceImpl extends BaseDao implements com.system.service.LoginService {
	
	public User fnUser(String username) {
		Map map = new HashMap();
		map.put("USERNAME", username);
		List list = getSqlMapClientTemplate().queryForList("fnUser", map);
		if (list.size() == 0 || list == null) {
			return null;
		} else {
			
			return (User)list.get(0);
		}
	}
	
	public User login(String username, String userpass) {
		Map map = new HashMap();
		map.put("USERNAME", username);
		map.put("USERPASS", userpass);
		List list = getSqlMapClientTemplate().queryForList("login", map);
		if (list.size() == 0 || list == null) {
			return null;
		} else {
			return (User)list.get(0);
		}
	}

	public List get_menu(String user_id) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("get_menu", "");
	}

	public List get_list_menu_my(String user_id) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("get_menu_my", user_id);
	}

	public List getSection(String type_id) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getSection", type_id);
		
	}

	public List getSensor(String type_id) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getSensor", type_id);
	}

	public List getSs(String sensor_id) {
		// TODO Auto-generated method stub
		//Map m1= (Map)getSqlMapClientTemplate().queryForList("getSensorByTypeId", sensor_id).get(0);
		String sql="select avg(t.data) a ,to_char(t.data_time,'yyyy-mm-dd hh24') s from TBL_"+sensor_id+" t "+  
					"where  to_char(t.data_time,'yyyy-mm-dd') =to_char(sysdate,'yyyy-mm-dd')  "+
					"group by to_char(t.data_time,'yyyy-mm-dd hh24') order by s ";
		
		
		return getSqlMapClientTemplate().queryForList("imAllCap", sql);
	}
	
	public List getYjz(String sensor_id) {
		// TODO Auto-generated method stub
		String sql="select * from sensor where sensor_id='"+sensor_id+"'";
		return getSqlMapClientTemplate().queryForList("imAllCap", sql);
	}

}

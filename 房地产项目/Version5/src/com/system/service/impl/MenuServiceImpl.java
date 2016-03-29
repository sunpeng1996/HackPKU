package com.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.common.BaseDao;
import com.common.PageBean;
import com.common.Util;
import com.system.service.MenuService;

/**
 * ==================================
 * Service实现类 - 系统管理 - 菜单管理 
 * ----------------------------------
 * @author ZGX 20150803
 * ==================================
 */
 
@Component
public class MenuServiceImpl extends BaseDao implements MenuService {

	/**
	 * 菜单列表
	 */
	public PageBean createQueryPage(Map param) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select q.*,w.menuname pname from t_MENU q left join t_MENU w on q.pid=w.id WHERE 1=1 ");
		if(!param.get("s_menu_name").toString().equals("")){
			sql.append(" AND q.menuname LIKE '%" + param.get("s_menu_name").toString() + "%' ");
		}
		sql.append(" ORDER BY q.pid ASC");
		List list = getSqlMapClientTemplate().queryForList("getAllMenus", Util.getPageSqlForMysql(sql.toString(),Integer.parseInt(param.get("pageSize").toString()),Integer.parseInt(param.get("currentPage").toString())));
		return Util.getPageBean(Integer.parseInt(param.get("pageSize").toString()), Integer.parseInt(param.get("currentPage").toString()), list, param, getSqlMapClientTemplate().queryForList("getAllMenus", sql.toString()).size());
	}
	
	/**
	 * 查询父级菜单
	 */
	public List parentMenus() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT M.* FROM t_MENU M WHERE isfather = 1 ");
		List list = getSqlMapClientTemplate().queryForList("parentMenus",sql.toString());
		return list;
	}

	/**
	 * 添加菜单
	 */
	public String addObject(Object obj) {
		try {
			getSqlMapClientTemplate().insert("addMenu", obj);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "notOk";
		}
	}

	/**
	 * 根据ID查询菜单
	 */
	public Object findObjectById(String id) {
		return getSqlMapClientTemplate().queryForObject("findMenuById", id);
	}

	/**
	 * 修改菜单
	 */
	@Transactional
	public String updateObject(Object obj) {
		try {
			getSqlMapClientTemplate().update("updateMenu", obj);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "notOk";
		}
	}

	/**
	 * 删除菜单
	 */
	@Transactional
	public String deleteObject(String id) {
		try {
			getSqlMapClientTemplate().delete("deleteMenu", id);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "notOk";
		}
	}
}

package com.system.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.common.PageBean;
@Component//@Service
public interface RoleService {
	
	public PageBean createQueryPage(Map param);
	public PageBean createQueryPageForCard(Map param);
	public PageBean createQueryPageForLy(Map param);
	public PageBean createQueryPageForSwjg(Map param);
	public PageBean createQueryPageForXzqh(Map param);
	public PageBean createQueryPageForFw(Map param);
	public PageBean createQueryPageForGio_1(Map param);
	
	public PageBean createQueryPageForRentalno(Map param);
	
	public PageBean createQueryPageForRentalyes(Map param);
	
	public String addObject(Object obj);
	
	public Object findObjectById(String id);
	
	public String updateObject(Object obj);
	
	public String deleteObject(String id);
	
	public String imCap(String cap);
	public void imCapJ(String cap) ;
	
	public List imAllCap(String cap);
	
	List findListforMenu(String role_id);
	
	List findListforMenuAll();
	
	String editRoleMenu(String[] menu_id,String role_id);
	
	public void imAllCapBatch(List<String> cap) throws SQLException;
	
	List getRoleMenuList(String roleId);
	
	public void editRoleMenu(String ids, String role_id) throws Exception;
	
	int jlFq(String str);
	
}

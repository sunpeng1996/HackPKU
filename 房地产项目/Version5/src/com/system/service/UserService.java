package com.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.common.PageBean;
@Component//@Service
public interface UserService {
	
	public PageBean createQueryPage(Map param);
	
	public String addObject(Object obj);
	
	public Object findObjectById(int id);
	
	public String updateObject(Object obj);
	
	public String deleteObject(String id);
	
	public List getRoleForSelect();
	
	public String searchYhm(String login_name);
	
	
	
}

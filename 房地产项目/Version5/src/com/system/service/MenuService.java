package com.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.common.PageBean;

/**
 * ==================================
 * Service接口 - 系统管理 - 菜单管理 
 * ----------------------------------
 * 
 * ==================================
 */
 
@Component
public interface MenuService {
	
	PageBean createQueryPage(Map param);
	
	List parentMenus();
	
	String addObject(Object obj);
	
	Object findObjectById(String string);
	
	String updateObject(Object obj);
	
	String deleteObject(String id);
}

package com.system.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.PageBean;
import com.common.Util;
import com.system.service.MenuService;
import com.system.service.RoleService;
import com.system.service.UserService;
import com.system.vo.Menu;
import com.system.vo.Role;
import com.system.vo.User;

/**
 * ==================================
 * 控制器 - 系统管理 - 菜单管理 
 * ----------------------------------

 * ==================================
 */
 
@Component
@RequestMapping("/menu")
@Scope("prototype")
public class MenuController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService rs;
	/**
	 * 菜单列表查询
	 */
	@RequestMapping(value = "menuList", method = { RequestMethod.GET, RequestMethod.POST })
	public String menuList(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "s_menu_name", defaultValue = "") String s_menu_name,
			@RequestParam(value = "currentPage", defaultValue = "1") String currentPage,
			@RequestParam(value = "pageSize", defaultValue = "20") String pageSize) {
		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_menu_name", s_menu_name);
		PageBean pageBean = menuService.createQueryPage(param);
		modelMap.put("pageBean", pageBean);
		return "system/menu/showMenu";
	}

	/**
	 * 菜单编辑
	 */
	@RequestMapping(value = "editMenu", method = { RequestMethod.GET, RequestMethod.POST })
	public void editMenu(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Menu menu) throws IOException {
		
		if(menu.getIsfather()==1){
			menu.setPid(0);
		}
		if (menu.getId()==0) {
			response.getWriter().print(menuService.addObject(menu));
		} else  {
			response.getWriter().print(menuService.updateObject(menu));
		}
	}

	/**
	 * 添加菜单页面
	 */
	@RequestMapping(value = "toAddMenu", method = {RequestMethod.GET, RequestMethod.POST })
	public String toAddMenu(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Menu menu, String sta) throws IOException {
		List parentMenus = menuService.parentMenus();
		request.setAttribute("parentMenus", parentMenus);
		return "system/menu/editMenu";
	}

	/**
	 * 编辑菜单页面
	 */
	
	@RequestMapping(value = "toUpdateMenu", method = {RequestMethod.GET, RequestMethod.POST })
	public String toUpdateMenu(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Menu menu, String sta) throws IOException {
		Map map = (Map) rs.imAllCap("select * from t_menu where id="+menu.getId()).get(0);
		request.setAttribute("map", map);
		List parentMenus = menuService.parentMenus();
		request.setAttribute("parentMenus", parentMenus);
		request.setAttribute("sta", sta);
		return "system/menu/editMenu";
	}

	/**
	 * 删除菜单
	 */
	@RequestMapping(value = "delMenu", method = {RequestMethod.GET, RequestMethod.POST })
	public void delMenu(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "delCheckBox", defaultValue = "") String[] delCheckBox)
			throws Exception {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				rs.imCap("delete from t_menu where id="+id);
				staus = "ok";
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(staus);
		pw.flush();

	}
	
	/**
	 * 按照角色权限显示首页菜单
	 * @author zgx 20150804
	 */
	@Autowired
	private RoleService roleService;
	@RequestMapping(value = "mainMenu", method = { RequestMethod.GET, RequestMethod.POST })
	public void mainMenu(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Role Role) throws IOException {
		User user = (User)request.getSession().getAttribute("user");
		System.out.println(user);
		int roleId = user.getRole_id();
		request.getSession().setAttribute("menulist", rs.imAllCap("select * from t_menu"));
		request.getSession().setAttribute("mymenulist", rs.imAllCap("select * from t_role_menu where role_id='"+roleId+"'"));
		response.sendRedirect(request.getContextPath()+"/view/main.jsp");
	}

}

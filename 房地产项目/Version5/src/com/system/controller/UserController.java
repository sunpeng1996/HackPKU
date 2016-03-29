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
import com.system.service.RoleService;
import com.system.service.UserService;
import com.system.vo.User;

@Component
// @Constroller
@RequestMapping("/user")
// 用户信息管理
@Scope("prototype")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService rService;

	/**
	 * 用户列表查询
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param username
	 * @param currentPage
	 * @param pageSize
	 * @param value
	 * @param values
	 * @return
	 */
	@RequestMapping(value = "userList", method = { RequestMethod.GET, RequestMethod.POST })
	public String userList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_user_name", defaultValue = "")
	String s_user_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_user_name", s_user_name);
		PageBean pageBean = userService.createQueryPage(param);
		modelMap.put("pageBean", pageBean);
		return "system/user/showUser";
	}

	/**
	 * 用户编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws IOException
	*/
	@RequestMapping(value = "editUser", method = { RequestMethod.GET, RequestMethod.POST })
	public void editUser(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
		if (user.getId()==0) {
			response.getWriter().print(userService.addObject(user));
		} else if (user.getId()!=0) {
			response.getWriter().print(userService.updateObject(user));
		}

	}
 
	/**
	 * 跳到编辑用户
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws IOException
	*/
	@RequestMapping(value = "toUpdateUser", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateUser(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
		Map map = (Map) rService.imAllCap("select * from t_user where id="+user.getId()).get(0);
		request.setAttribute("map", map);
		return "system/user/editUser";
	}
	 
	/**
	 * 跳到查看用户
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws IOException
	
	@RequestMapping(value = "toViewUser", method = { RequestMethod.GET, RequestMethod.POST })
	public String toViewUser(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
		Map map = (Map) userService.findObjectById(user.getUSER_ID());
		request.setAttribute("map", map);
		List rolelist = userService.getRoleForSelect();
		request.setAttribute("rolelist", rolelist);
		return "system/user/viewUser";
	}
 */
	/**
	 * 删除用户
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param delCheckBox
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delUser", method = { RequestMethod.GET, RequestMethod.POST })
	public void delUser(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				List sql = new ArrayList();
				sql.add("delete from t_user where id='" + id + "'");
				try {
					rService.imAllCapBatch(sql);
					staus = "ok";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					staus = "notOk";
				}
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(staus);
		pw.flush();

	}

	/**
	 * 获取所有用户角色
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "getRoleForSelect", method = { RequestMethod.GET, RequestMethod.POST })
	public void getRoleForSelect(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print(Util.jsonListStr(userService.getRoleForSelect()));
	}

	/**
	 * 查询用户名是否重复
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "searchYhm", method = { RequestMethod.GET, RequestMethod.POST })
	public void searchYhm(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
		response.getWriter().print((userService.searchYhm(user.getLoginname())));
	}

}

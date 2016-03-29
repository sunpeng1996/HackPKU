package com.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
import com.system.service.RoleService;
import com.system.vo.Rental_no;
import com.system.vo.Rental_yes;
import com.system.vo.Role;

@Component
//@Constroller
@RequestMapping("/rental")
//房屋使用信息管理
@Scope("prototype")
public class RentalController {

	@Autowired
	private RoleService roleService;

	/**
	 * 非出租列表查询
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Rolename
	 * @param currentPage
	 * @param pageSize
	 * @param value
	 * @param values
	 * @return
	 */
	@RequestMapping(value = "rentalnoList", method = { RequestMethod.GET, RequestMethod.POST })
	public String rentalnoList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPageForRentalno(param);
		modelMap.put("pageBean", pageBean);
		return "system/rentalno/show";
	}
	
	
	/**
	 * 出租列表查询
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Rolename
	 * @param currentPage
	 * @param pageSize
	 * @param value
	 * @param values
	 * @return
	 */
	@RequestMapping(value = "rentalyesList", method = { RequestMethod.GET, RequestMethod.POST })
	public String rentalyesList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPageForRentalyes(param);
		modelMap.put("pageBean", pageBean);
		return "system/rentalyes/show";
	}

	/**
	 * 非出租编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editRentalno", method = { RequestMethod.GET, RequestMethod.POST })
	public void editRole(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Rental_no v) throws IOException {
		if (v.getId()==0) {
			roleService.imCap("insert into t_rental_no (data_2,data_3,data_4,data_5,data_6,data_7,data_8,data_9,data_10,data_11,data_12,data_13,data_14,data_15,data_16,data_17,data_18,data_19,data_20,data_21,data_22,data_23) values (  '"+v.getData_2()+"' , '"+v.getData_3()+"' , '"+v.getData_4()+"' , '"+v.getData_5()+"' , '"+v.getData_6()+"' , '"+v.getData_7()+"' , '"+v.getData_8()+"' , '"+v.getData_9()+"' , '"+v.getData_10()+"' , '"+v.getData_11()+"' , '"+v.getData_12()+"' , '"+v.getData_13()+"' , '"+v.getData_14()+"' , '"+v.getData_15()+"' , '"+v.getData_16()+"' , '"+v.getData_17()+"' , '"+v.getData_18()+"' , '"+v.getData_19()+"' , '"+v.getData_20()+"' , '"+v.getData_21()+"' , '"+v.getData_22()+"' , '"+v.getData_23()+"' )  ");
		} else {
			roleService.imCap(" update t_rental_no set data_2 ='"+v.getData_2()+"'  ,data_3 ='"+v.getData_3()+"'  ,data_4 ='"+v.getData_4()+"'  ,data_5 ='"+v.getData_5()+"'  ,data_6 ='"+v.getData_6()+"'  ,data_7 ='"+v.getData_7()+"'  ,data_8 ='"+v.getData_8()+"'  ,data_9 ='"+v.getData_9()+"'  ,data_10 ='"+v.getData_10()+"'  ,data_11 ='"+v.getData_11()+"'  ,data_12 ='"+v.getData_12()+"'  ,data_13 ='"+v.getData_13()+"'  ,data_14 ='"+v.getData_14()+"'  ,data_15 ='"+v.getData_15()+"'  ,data_16 ='"+v.getData_16()+"'  ,data_17 ='"+v.getData_17()+"'  ,data_18 ='"+v.getData_18()+"'  ,data_19 ='"+v.getData_19()+"'  ,data_20 ='"+v.getData_20()+"'  ,data_21 ='"+v.getData_21()+"'  ,data_22 ='"+v.getData_22()+"'  ,data_23 ='"+v.getData_23()+"'   where id ='"+v.getId()+"'  ");
		}

	}
	
	/**
	 * 出租编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editRentalyes", method = { RequestMethod.GET, RequestMethod.POST })
	public void editRentalyes(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Rental_yes v) throws IOException {
		if (v.getId()==0) {
			roleService.imCap("insert into t_rental_yes (data_2,data_3,data_4,data_5,data_6,data_7,data_8,data_9,data_10,data_11,data_12,data_13,data_14,data_15,data_16,data_17,data_18,data_19,data_20,data_21,data_22,data_23,data_24,data_25,data_26,data_27) values ( '"+v.getData_2()+"' , '"+v.getData_3()+"' , '"+v.getData_4()+"' , '"+v.getData_5()+"' , '"+v.getData_6()+"' , '"+v.getData_7()+"' , '"+v.getData_8()+"' , '"+v.getData_9()+"' , '"+v.getData_10()+"' , '"+v.getData_11()+"' , '"+v.getData_12()+"' , '"+v.getData_13()+"' , '"+v.getData_14()+"' , '"+v.getData_15()+"' , '"+v.getData_16()+"' , '"+v.getData_17()+"' , '"+v.getData_18()+"' , '"+v.getData_19()+"' , '"+v.getData_20()+"' , '"+v.getData_21()+"' , '"+v.getData_22()+"' , '"+v.getData_23()+"' , '"+v.getData_24()+"' , '"+v.getData_25()+"' , '"+v.getData_26()+"' , '"+v.getData_27()+"' )  ");
		} else {
			roleService.imCap("update t_rental_yes set data_2 ='"+v.getData_2()+"'  ,data_3 ='"+v.getData_3()+"'  ,data_4 ='"+v.getData_4()+"'  ,data_5 ='"+v.getData_5()+"'  ,data_6 ='"+v.getData_6()+"'  ,data_7 ='"+v.getData_7()+"'  ,data_8 ='"+v.getData_8()+"'  ,data_9 ='"+v.getData_9()+"'  ,data_10 ='"+v.getData_10()+"'  ,data_11 ='"+v.getData_11()+"'  ,data_12 ='"+v.getData_12()+"'  ,data_13 ='"+v.getData_13()+"'  ,data_14 ='"+v.getData_14()+"'  ,data_15 ='"+v.getData_15()+"'  ,data_16 ='"+v.getData_16()+"'  ,data_17 ='"+v.getData_17()+"'  ,data_18 ='"+v.getData_18()+"'  ,data_19 ='"+v.getData_19()+"'  ,data_20 ='"+v.getData_20()+"'  ,data_21 ='"+v.getData_21()+"'  ,data_22 ='"+v.getData_22()+"'  ,data_23 ='"+v.getData_23()+"'  ,data_24 ='"+v.getData_24()+"'  ,data_25 ='"+v.getData_25()+"'  ,data_26 ='"+v.getData_26()+"'  ,data_27 ='"+v.getData_27()+"'   where id ='"+v.getId()+"'  ");
		}

	}

	/**
	 * 跳到非出租
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateRentalno", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateRole(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Role Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_rental_no where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/rentalno/edit";
	}
	
	/**
	 * 跳到出租
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateRentalyes", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateRentalno(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Role Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_rental_yes where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/rentalyes/edit";
	}
	
	

	/**
	 * 删除非出租
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param delCheckBox
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delRentalno", method = { RequestMethod.GET, RequestMethod.POST })
	public void delRole(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_rental_no where id="+id);
				if (flag.equals("notOk")) {
					staus = flag;
					break;
				} else {
					staus = "ok";
				}

			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(staus);
		pw.flush();

	}

	/**
	 * 删除出租
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param delCheckBox
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delRentalyes", method = { RequestMethod.GET, RequestMethod.POST })
	public void delRentalyes(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_rental_yes where id="+id);
				if (flag.equals("notOk")) {
					staus = flag;
					break;
				} else {
					staus = "ok";
				}

			}
		}
		PrintWriter pw = response.getWriter();
		pw.write(staus);
		pw.flush();

	}

}

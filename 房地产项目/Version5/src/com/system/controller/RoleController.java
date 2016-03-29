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
import com.system.vo.Card;
import com.system.vo.House;
import com.system.vo.Lyxx;
import com.system.vo.Role;
import com.system.vo.Swjg;
import com.system.vo.Xzqh;

@Component
//@Constroller
@RequestMapping("/role")
//角色信息管理
@Scope("prototype")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * 角色列表查询
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
	@RequestMapping(value = "roleList", method = { RequestMethod.GET, RequestMethod.POST })
	public String roleList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPage(param);
		modelMap.put("pageBean", pageBean);
		return "system/role/showRole";
	}

	/**
	 * 角色编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editRole", method = { RequestMethod.GET, RequestMethod.POST })
	public void editRole(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Role Role) throws IOException {
		if (Role.getId()==0) {
			response.getWriter().print(roleService.addObject(Role));
		} else {
			response.getWriter().print(roleService.updateObject(Role));
		}

	}

	/**
	 * 跳到编辑角色
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateRole", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateRole(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Role Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_role where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/role/editRole";
	}
	
	/**
	 * 跳到查看角色
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toViewRole", method = { RequestMethod.GET, RequestMethod.POST })
	public String toViewRole(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Role Role) throws IOException {
		//Map map = (Map) roleService.findObjectById(Role.getId()());
		//request.setAttribute("map", map);
		return "system/role/viewRole";
	}


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
	@RequestMapping(value = "delRole", method = { RequestMethod.GET, RequestMethod.POST })
	public void delRole(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_role where id="+id);
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
	 * 编辑菜单权限页面
	 * @author zgx 20150804
	 */
	@RequestMapping(value = "toEditRoleMenu", method = { RequestMethod.GET, RequestMethod.POST })
	public String toEditRoleMenu(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Role Role) throws IOException {
		String roleId = request.getParameter("roleId"); // 权限ID
		request.setAttribute("list", roleService.imAllCap("select * from t_role_menu where  role_id="+roleId));
		request.setAttribute("roleId", roleId);
		request.setAttribute("allmenu", roleService.imAllCap("select * from t_menu"));
		return "system/role/showRoleMenu";
	}

	/**
	 * 编辑菜单权限
	 * @author zgx 20150804
	 */
	@RequestMapping(value = "editRoleMenu", method = { RequestMethod.GET, RequestMethod.POST })
	public void editRoleMenu(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, String[] menu_id, Role role) throws IOException {
		
			String role_id = request.getParameter("roleId");
			roleService.imCap("delete from t_role_menu where role_id="+role_id);
			System.out.println(role_id);
			for(String a:menu_id){
				roleService.imCap("insert into t_role_menu values("+role_id+","+a+")");
			}
			response.getWriter().print("ok");
		
	}
	
	/**
	 * 证件列表查询
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
	@RequestMapping(value = "cardList", method = { RequestMethod.GET, RequestMethod.POST })
	public String cardList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPageForCard(param);
		modelMap.put("pageBean", pageBean);
		return "system/card/show";
	}
	
	/**
	 * 证件编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editCard", method = { RequestMethod.GET, RequestMethod.POST })
	public void editCard(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Card Role) throws IOException {
		if (Role.getId()==0) {
			roleService.imCap("insert into t_card(cardname,remark) values('"+Role.getCardname()+"','"+Role.getRemark()+"')");
		} else {
			roleService.imCap("update  t_card set cardname='"+Role.getCardname()+"',remark='"+Role.getRemark()+"' where id='"+Role.getId()+"'");
		}

	}
	
	/**
	 * 跳到编辑证件
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateCard", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateCard(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Card Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_card where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/card/edit";
	}
	
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
	@RequestMapping(value = "delCard", method = { RequestMethod.GET, RequestMethod.POST })
	public void delCard(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_card where id="+id);
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
	 * 楼宇列表查询
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
	@RequestMapping(value = "lyList", method = { RequestMethod.GET, RequestMethod.POST })
	public String lyList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPageForLy(param);
		modelMap.put("pageBean", pageBean);
		return "system/lyxx/show";
	}
	
	/**
	 * 楼宇编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editLy", method = { RequestMethod.GET, RequestMethod.POST })
	public void editLy(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Lyxx v) throws IOException {
		if (v.getId()==0) {
			roleService.imCap("insert into t_lyjcxx (lymc,lyzts,lydz,swjg_id,xzqh,fwscjx) values ( '"+v.getLymc()+"' , '"+v.getLyzts()+"' , '"+v.getLydz()+"' , '"+v.getSwjg_id()+"' , '"+v.getXzqh()+"' , '"+v.getFwscjx()+"' )   ");
		} else {
			roleService.imCap("update t_lyjcxx set lymc ='"+v.getLymc()+"'  ,lyzts ='"+v.getLyzts()+"'  ,lydz ='"+v.getLydz()+"'  ,swjg_id ='"+v.getSwjg_id()+"'  ,xzqh ='"+v.getXzqh()+"'  ,fwscjx ='"+v.getFwscjx()+"'   where id ='"+v.getId()+"'   ");
		}

	}
	
	/**
	 * 跳到编辑证件
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateLy", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateLy(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Lyxx Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_lyjcxx where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/lyxx/edit";
	}
	
	/**
	 * 删除楼宇
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param delCheckBox
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delLy", method = { RequestMethod.GET, RequestMethod.POST })
	public void delLy(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_lyjcxx where id="+id);
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
	 * 税务机关列表查询
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
	@RequestMapping(value = "swjgList", method = { RequestMethod.GET, RequestMethod.POST })
	public String swjgList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPageForSwjg(param);
		modelMap.put("pageBean", pageBean);
		return "system/swjg/show";
	}
	
	/**
	 * 行政区划列表查询
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
	@RequestMapping(value = "xzqhList", method = { RequestMethod.GET, RequestMethod.POST })
	public String xzqhList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPageForXzqh(param);
		modelMap.put("pageBean", pageBean);
		return "system/xzqh/show";
	}

	
	/**
	 * 删除税务机关
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param delCheckBox
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delSwjg", method = { RequestMethod.GET, RequestMethod.POST })
	public void delSwjg(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_swjg where id="+id);
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
	 * 删除行政区划
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param delCheckBox
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delXzqh", method = { RequestMethod.GET, RequestMethod.POST })
	public void delXzqh(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_xzqh where id="+id);
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
	 * 跳到编辑税务机关
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateSwjg", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateSwjg(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Lyxx Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_swjg where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/swjg/edit";
	}
	
	/**
	 * 跳到编辑行政区划
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateXzqh", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateXzqh(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Lyxx Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_Xzqh where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/xzqh/edit";
	}
	
	/**
	 * 税务机关编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editSwjg", method = { RequestMethod.GET, RequestMethod.POST })
	public void editSwjg(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Swjg v) throws IOException {
		if (v.getId()==0) {
			roleService.imCap("insert into t_swjg (jgmc) values (  '"+v.getJgmc()+"' ) ");
		} else {
			roleService.imCap("update t_swjg set jgmc ='"+v.getJgmc()+"'   where id ='"+v.getId()+"'  ");
		}

	}
	
	/**
	 * 行政区划编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editXzqh", method = { RequestMethod.GET, RequestMethod.POST })
	public void editXzqh(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Xzqh v) throws IOException {
		if (v.getId()==0) {
			roleService.imCap("insert into t_Xzqh (xzqhmc) values (  '"+v.getXzqhmc()+"' )  ");
		} else {
			roleService.imCap(" update t_Xzqh set xzqhmc ='"+v.getXzqhmc()+"'   where  id ='"+v.getId()+"'  ");
		}

	}
	
	
	/**
	 * 房屋列表查询
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
	@RequestMapping(value = "fwList", method = { RequestMethod.GET, RequestMethod.POST })
	public String fwList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "s_role_name", defaultValue = "")
	String s_role_name, @RequestParam(value = "currentPage", defaultValue = "1")
	String currentPage, @RequestParam(value = "pageSize", defaultValue = "20")
	String pageSize, @RequestParam(value = "value", defaultValue = "")
	String value, @RequestParam(value = "value", defaultValue = "")
	String[] values) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_role_name", s_role_name);
		PageBean pageBean = roleService.createQueryPageForFw(param);
		modelMap.put("pageBean", pageBean);
		return "system/fw/show";
	}
	
	/**
	 * 房屋编辑
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "editFw", method = { RequestMethod.GET, RequestMethod.POST })
	public void editFw(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, House v) throws IOException {
		if (v.getId()==0) {
			roleService.imCap("insert into t_house (data_2,data_3,data_4,data_5,data_6,data_7,data_8,data_9,data_10,data_11,data_12,data_13,data_14,data_15,data_16,data_18,data_19,data_20,data_21,data_17) values (  '"+v.getData_2()+"' , '"+v.getData_3()+"' , '"+v.getData_4()+"' , '"+v.getData_5()+"' , '"+v.getData_6()+"' , '"+v.getData_7()+"' , '"+v.getData_8()+"' , '"+v.getData_9()+"' , '"+v.getData_10()+"' , '"+v.getData_11()+"' , '"+v.getData_12()+"' , '"+v.getData_13()+"' , '"+v.getData_14()+"' , '"+v.getData_15()+"' , '"+v.getData_16()+"' , '"+v.getData_18()+"' , '"+v.getData_19()+"' , '"+v.getData_20()+"' , '"+v.getData_21()+"' , '"+v.getData_17()+"' )  ");
		} else {
			roleService.imCap(" update t_house set data_2 ='"+v.getData_2()+"'  ,data_3 ='"+v.getData_3()+"'  ,data_4 ='"+v.getData_4()+"'  ,data_5 ='"+v.getData_5()+"'  ,data_6 ='"+v.getData_6()+"'  ,data_7 ='"+v.getData_7()+"'  ,data_8 ='"+v.getData_8()+"'  ,data_9 ='"+v.getData_9()+"'  ,data_10 ='"+v.getData_10()+"'  ,data_11 ='"+v.getData_11()+"'  ,data_12 ='"+v.getData_12()+"'  ,data_13 ='"+v.getData_13()+"'  ,data_14 ='"+v.getData_14()+"'  ,data_15 ='"+v.getData_15()+"'  ,data_16 ='"+v.getData_16()+"'  ,data_18 ='"+v.getData_18()+"'  ,data_19 ='"+v.getData_19()+"'  ,data_20 ='"+v.getData_20()+"'  ,data_21 ='"+v.getData_21()+"'  ,data_17 ='"+v.getData_17()+"'   where id ='"+v.getId()+"'   ");
		}

	}
	
	/**
	 * 跳到编辑房屋
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param Role
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "toUpdateFw", method = { RequestMethod.GET, RequestMethod.POST })
	public String toUpdateFw(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, Lyxx Role) throws IOException {
		Map map = (Map) roleService.imAllCap("select * from t_house where id="+Role.getId()).get(0);
		request.setAttribute("map", map);
		return "system/fw/edit";
	}
	
	/**
	 * 删除房屋
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param delCheckBox
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "delFw", method = { RequestMethod.GET, RequestMethod.POST })
	public void delFw(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "delCheckBox", defaultValue = "")
	String[] delCheckBox) throws IOException {
		String staus = "";
		if (delCheckBox.length > 0) {
			for (String id : delCheckBox) {
				String flag = roleService.imCap("delete from t_house where id="+id);
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

package com.gio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.gio.po.Building;
import com.gio.po.BuildingUsageState;
import com.gio.po.HouseMsg;
import com.gio.po.HouseVo;
import com.gio.po.Names;
import com.gio.po.Position;
import com.gio.service.QueryService;
import com.gio.vo.BuildingTaxCountVo;
import com.system.service.RoleService;

/**
 * ==================================
 * 控制器 - 统计查询
 * ----------------------------------
 * 
 * ==================================
 */
 
@Component
@RequestMapping("gio")
@Scope("prototype")
public class GioController {

	
	@Autowired
	private RoleService rs;

	@Autowired
	private QueryService qs;

	@RequestMapping(value = "showHouseMsg", method = { RequestMethod.GET, RequestMethod.POST })
	public String showHouseMsg(
			ModelMap modelMap,
			@RequestParam(value = "floor", defaultValue = "1") int floor,
			@RequestParam(value = "bid", defaultValue = "1") int bid,
			@RequestParam(value = "hid", defaultValue = "1") int hid,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Position p = new Position();
		p.setBid(bid);
		p.setFloor(floor);
		p.setNum(hid);
		List<HouseMsg> list = qs.getHouseMsg(p);
		List<Integer> whids = qs.getWarnedHouseByFloor(p);

		if(list.size() == 0){
			modelMap.put("errorflag", 1);
			modelMap.put("hids", whids);
			modelMap.put("bid", bid);
			modelMap.put("floor", floor);
			return "floor";
		}else{
			modelMap.put("houseMsgList", list);
			return "/gio/showHouseMsg";
		}
		
	} 
	@RequestMapping(value = "showHouse", method = { RequestMethod.GET, RequestMethod.POST })
	public String showHouse(
			ModelMap modelMap,
			@RequestParam(value = "floor", defaultValue = "1") int floor,
			@RequestParam(value = "bid", defaultValue = "1") int bid,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		modelMap.put("floorNum", floor);
		Position p = new Position();
		p.setBid(bid);
		p.setFloor(floor);
		List<Integer> whids = qs.getWarnedHouseByFloor(p);

		modelMap.put("errorflag", 0);
		modelMap.put("hids", whids);
		modelMap.put("bid", bid);
		modelMap.put("floor", floor);
		return "floor";
	} 
	@RequestMapping(value = "showBuilding", method = { RequestMethod.GET, RequestMethod.POST })
	public String showBuilding(
			ModelMap modelMap,
			@RequestParam(value = "bid", defaultValue = "1") int bid,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Building> bList = qs.getAllBuildings();
		Building building = null;
		for(Building b:bList){
			if(b.getBid() == bid){
				building = b;
			}
		}
		String data = qs.getChartData(bid);
		modelMap.put("bname", building.getBname());

		modelMap.put("bid", building.getBid());
		modelMap.put("data", data);
		List<Integer> warnFloor = qs.getWarnedFloor(bid);
		modelMap.put("warnFloor", warnFloor);
		return "building";
	} 
	@RequestMapping(value = "getChartData", method = { RequestMethod.GET, RequestMethod.POST })
	public void getChartData(
			ModelMap modelMap,
			@RequestParam(value = "bid", defaultValue = "1") int bid,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Building> bList = qs.getAllBuildings();
		Building building = null;
		for(Building b:bList){
			if(b.getBid() == bid){
				building = b;
			}
		}
		String data = qs.getChartData(bid);
		response.getWriter().print(data);
	} 
	@RequestMapping(value = "showChart", method = { RequestMethod.GET, RequestMethod.POST })
	public String showChart(
			ModelMap modelMap,
			@RequestParam(value = "lyid", defaultValue = "1") int lyid,
			HttpServletRequest request,
			HttpServletResponse response) {
		List<Building> bList = qs.getAllBuildings();
		Building building = null;
		for(Building b:bList){
			if(b.getBid() == lyid){
				building = b;
			}
		}
		String data = qs.getChartData(lyid);
		modelMap.put("bname", building.getBname());
		modelMap.put("data", data);
		return "gio/chart";
	} 
	@RequestMapping(value = "showRentalWarningHouse", method = { RequestMethod.GET, RequestMethod.POST })
	public String showRentalWarningHouse(
			ModelMap modelMap,
			@RequestParam(value = "bid", defaultValue = "1") int bid,
			HttpServletRequest request,
			HttpServletResponse response) {
		List<Building> bList = qs.getAllBuildings();
		Building building = null;
		for(Building b:bList){
			if(b.getBid() == bid){
				building = b;
			}
		}
		List<HouseVo> houseList = qs.getRentalWarnedHouseByBid(building.getBid());
		modelMap.put("houseList", houseList);
		modelMap.put("bname",building.getBname());
		return "gio/showRentalWarningHouse";
	} 
	
	@RequestMapping(value = "showHouseUsageState", method = { RequestMethod.GET, RequestMethod.POST })
	public String showHouseUsageState(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response) {
		List<BuildingUsageState> bsList = qs.queryBuildingStateUsage();
		modelMap.put("bsList", bsList);
		return "gio/gio_2";
	} 

	@RequestMapping(value = "showWarningHouse", method = { RequestMethod.GET, RequestMethod.POST })
	public String showWarningHouse(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response) {
		List<HouseVo> houseList = qs.getWarnedHouses();
		modelMap.put("houseList", houseList);
		return "gio/showWarningHouse";
	} 

	@RequestMapping(value = "showBuildingTaxYOYBasis", method = { RequestMethod.GET, RequestMethod.POST })
	public String showBuildingTaxYOYBasis(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response) {
		List<Building> bList = qs.getAllBuildings();
		Map<Building,List<BuildingTaxCountVo>> bMes = new LinkedHashMap<Building, List<BuildingTaxCountVo>>();
		for(Building b:bList){
			bMes.put(b, qs.getBuildingTaxCountVoByBuilding(b.getBid()));
		}
		modelMap.put("bMes", bMes);
		return "gio/showBuildingYOYBasisTrans";
	}
	@RequestMapping(value = "showBuildingTaxCount", method = { RequestMethod.GET, RequestMethod.POST })
	public String showBuildingTaxCount(
			ModelMap modelMap,
			@RequestParam(value = "year", defaultValue = "") Integer year,
			HttpServletRequest request,
			HttpServletResponse response) {
		if(year == 0 || year == null) {
			modelMap.put("buildingTaxCountList", null);
			return "gio/showBuildingTaxTrans";
		}
		List<BuildingTaxCountVo> buildingTaxCountList = qs.getBuildingTaxCountVoByYear(year);
		modelMap.put("buildingTaxCountList", buildingTaxCountList);
		return "gio/showBuildingTaxTrans";
	}
	@RequestMapping(value = "queryHouseMesByNames", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryHouseMesByNames(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "rental_name", defaultValue = "") String rental_name,
			@RequestParam(value = "user_name", defaultValue = "") String user_name,
			@RequestParam(value = "owner_name", defaultValue = "")	String owner_name,
			@RequestParam(value = "currentPage", defaultValue = "1") String currentPage,
			@RequestParam(value = "pageSize", defaultValue = "20") String pageSize) {

		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("names", new Names(owner_name, user_name, rental_name));

		PageBean pageBean = qs.createQueryPageForqueryHouseMesByNames(param);
		modelMap.put("pageBean", pageBean);
		return "gio/gio_1";
	}
	/**
	 * 房产信息查询（模糊/精确查询）
	 * @param modelMap
	 * @param request
	 * @param response
	 * @param s_menu_name
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "gio_1", method = { RequestMethod.GET, RequestMethod.POST })
	public String gio_1(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "s_role_name", defaultValue = "")	String s_role_name,
			@RequestParam(value = "s_menu_name", defaultValue = "") String s_menu_name,
			@RequestParam(value = "currentPage", defaultValue = "1") String currentPage,
			@RequestParam(value = "pageSize", defaultValue = "20") String pageSize) {
		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("s_menu_name", s_menu_name);

		param.put("s_role_name", s_role_name);
		PageBean pageBean = rs.createQueryPageForGio_1(param);
		pageBean.setList(new ArrayList());
		modelMap.put("pageBean", pageBean);
		return "gio/gio_1";
	}
	@RequestMapping(value = "taxList", method = { RequestMethod.GET, RequestMethod.POST })
	public String taxList(
			ModelMap modelMap,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "tax_id", defaultValue = "") String tax_id,
			@RequestParam(value = "currentPage", defaultValue = "1") String currentPage,
			@RequestParam(value = "pageSize", defaultValue = "20") String pageSize) {
		Map param = new HashMap();
		param.put("pageSize", pageSize);
		param.put("currentPage", currentPage);
		param.put("tax_id", tax_id);
		PageBean pageBean = qs.createQueryPageForTaxList(param);
		System.out.println(pageBean.getList().get(0));
		modelMap.put("pageBean", pageBean);
		return "gio/showTaxor";
	}
}
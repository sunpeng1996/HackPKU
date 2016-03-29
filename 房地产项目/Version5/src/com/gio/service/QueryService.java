package com.gio.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.common.PageBean;
import com.gio.po.Building;
import com.gio.po.BuildingUsageState;
import com.gio.po.HouseMsg;
import com.gio.po.HouseVo;
import com.gio.po.Position;
import com.gio.vo.BuildingTaxCountVo;

@Component
public interface QueryService {

	public PageBean createQueryPageForqueryHouseMesByNames(Map params) ;
	public PageBean createQueryPageForTaxList(Map params);
	public List<BuildingUsageState> queryBuildingStateUsage();
	public List<BuildingTaxCountVo> getBuildingTaxCountVoByYear(int year);
	public List<BuildingTaxCountVo> getBuildingTaxCountVoByBuilding(int bid);
	public List<Building> getAllBuildings();
	public String getChartData(int bid);
	public List<HouseVo> getWarnedHouses();
	public List<HouseVo> getRentalWarnedHouseByBid(int bid);
	public List<Integer> getWarnedFloor(int bid);
	public List<Integer> getWarnedHouseByFloor(Position p);
	public List<HouseMsg> getHouseMsg(Position p);
}

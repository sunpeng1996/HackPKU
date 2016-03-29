package com.gio.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.PageBean;
import com.common.Util;
import com.gio.mapper.BuildingQueryMapper;
import com.gio.mapper.HouseQueryMapper;
import com.gio.mapper.HouseUsageStateQueryMapper;
import com.gio.mapper.TaxorMapper;
import com.gio.mapper.WarningMapper;
import com.gio.po.Building;
import com.gio.po.BuildingUsageState;
import com.gio.po.FloorPo;
import com.gio.po.HouseMsg;
import com.gio.po.HouseVo;
import com.gio.po.Names;
import com.gio.po.Position;
import com.gio.po.Taxor;
import com.gio.vo.BuildingTaxCountVo;
import com.gio.vo.HouseQueryVo;
import com.gio.vo.HouseUsageStateQueryVo;
import com.gio.vo.TaxIncome;

@Component
public class QueryServiceImpl implements QueryService {
	@Autowired
	private HouseQueryMapper houseQueryMapper;
	@Autowired 
	private HouseUsageStateQueryMapper houseUsageStateQueryMapper;
	@Autowired
	private TaxorMapper taxorMapper;
	@Autowired
	private BuildingQueryMapper buildingQueryMapper;
	@Autowired
	private WarningMapper warningMapper;
	@Override
	public PageBean createQueryPageForqueryHouseMesByNames(Map param) {
		List<HouseQueryVo> list = houseQueryMapper.QueryHouseByNames((Names)param.get("names"));
		
		return Util.getPageBean(Integer.parseInt(param.get("pageSize").toString()),
				Integer.parseInt(param.get("currentPage").toString()), list, param,list.size());
		
	}
	@Override
	public PageBean createQueryPageForTaxList(Map param) {
		List<Taxor> list = taxorMapper.QueryTaxorByid(param.get("tax_id").toString());
		return Util.getPageBean(Integer.parseInt(param.get("pageSize").toString()),
				Integer.parseInt(param.get("currentPage").toString()), list, param,list.size());
	}
	@Override
	public List<BuildingUsageState> queryBuildingStateUsage() {
		List<Building> buildings = houseUsageStateQueryMapper.getAllBuildings();
		List<BuildingUsageState> bsList = new ArrayList<BuildingUsageState>();
		for(Building b: buildings){
			List<HouseUsageStateQueryVo> houseUsageStates = houseUsageStateQueryMapper.QueryHouseUsageState(b.getBid());
			BuildingUsageState bus = new BuildingUsageState();
			bus.setBuilding(b);
			int count = 0;
			for(HouseUsageStateQueryVo h:houseUsageStates){
				count += h.getCount();
			}
			Map<String,Float> houseUsage = new HashMap<String,Float>();
			for(HouseUsageStateQueryVo h:houseUsageStates){
				houseUsage.put(h.getUsage(), (float)(Math.round(((float)h.getCount()/count)*100)));
			}
			bus.setHouseUsage(houseUsage);
			bsList.add(bus);
		}
		return bsList;
	}
	@Override
	public List<BuildingTaxCountVo> getBuildingTaxCountVoByYear(int year) {
		return buildingQueryMapper.getBuildingTaxCountVoByYear(year);
	}
	@Override
	public List<BuildingTaxCountVo> getBuildingTaxCountVoByBuilding(int bid) {
		List<BuildingTaxCountVo> blist = buildingQueryMapper.getBuildingTaxCountVoByBuilding(bid);
		BuildingTaxCountVo btc = new BuildingTaxCountVo();
		btc.setBname("同比");
		btc.setJan(this.toFloatBy2(blist.get(1).getJan()/blist.get(0).getJan() - 1));
		btc.setFeb(this.toFloatBy2(blist.get(1).getFeb()/blist.get(0).getFeb() - 1));
		btc.setMar(this.toFloatBy2(blist.get(1).getMar()/blist.get(0).getMar() - 1));
		btc.setApri(this.toFloatBy2(blist.get(1).getApri()/blist.get(0).getApri() - 1));
		btc.setMay(this.toFloatBy2(blist.get(1).getMay()/blist.get(0).getMay() - 1));
		btc.setJune(this.toFloatBy2(blist.get(1).getJune()/blist.get(0).getJune() - 1));
		btc.setJuly(this.toFloatBy2(blist.get(1).getJuly()/blist.get(0).getJuly() - 1));
		btc.setAug(this.toFloatBy2(blist.get(1).getAug()/blist.get(0).getAug() - 1));
		btc.setSept(this.toFloatBy2(blist.get(1).getSept()/blist.get(0).getSept() - 1));
		btc.setOct(this.toFloatBy2(blist.get(1).getOct()/blist.get(0).getOct() - 1));
		btc.setNov(this.toFloatBy2(blist.get(1).getNov()/blist.get(0).getNov() - 1));
		btc.setDec(this.toFloatBy2(blist.get(1).getDec()/blist.get(0).getDec() - 1));
		btc.setYear(null);
		blist.add(btc);
		return blist;
	}
	@Override
	public List<Building> getAllBuildings() {
		return houseUsageStateQueryMapper.getAllBuildings();
	}
	private float toFloatBy2(float num){
		return (float)(Math.round(num*100));
	}
	@Override
	public String getChartData(int bid) {
		List<TaxIncome> tList = buildingQueryMapper.getTaxIncome(bid);
		StringBuilder  sb = new StringBuilder();
		sb.append("[['");
		int len = tList.size();
		int i = 0;
		for(TaxIncome t:tList){
			i++;
			sb.append(t.getTax_type());
			sb.append("',");
			sb.append(t.getSum());
			if(i!=len){
				sb.append("],['");
			}
		}
		sb.append("]]");
		return sb.toString();
	}
	@Override
	public List<HouseVo> getWarnedHouses() {
		Date d = new Date();
		return warningMapper.getWarnedHouse(d.toLocaleString());
	}
	@Override
	public List<HouseVo> getRentalWarnedHouseByBid(int bid) {
		return warningMapper.getRentalWarnedHouseByBid(bid);
	}
	@Override
	public List<Integer> getWarnedFloor(int bid) {
		FloorPo fp = new FloorPo();
		fp.setFloor(bid);

		Date d = new Date();
		fp.setTimestamp(d.toLocaleString());
		return warningMapper.getWarnedFloor(fp);
	}
	@Override
	public List<Integer> getWarnedHouseByFloor(Position p) {
		return warningMapper.getWarnedHouseByFloor(p);
	}
	@Override
	public List<HouseMsg> getHouseMsg(Position p) {
		return houseQueryMapper.getHouseMsg(p);
	}
}

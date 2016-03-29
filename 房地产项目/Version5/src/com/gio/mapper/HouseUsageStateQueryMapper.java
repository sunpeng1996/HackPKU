package com.gio.mapper;

import java.util.List;

import com.gio.po.Building;
import com.gio.vo.HouseUsageStateQueryVo;

public interface HouseUsageStateQueryMapper {
	public List<Building> getAllBuildings();
	public List<HouseUsageStateQueryVo> QueryHouseUsageState(int bid);
}

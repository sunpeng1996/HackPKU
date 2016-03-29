package com.gio.mapper;

import java.util.List;

import com.gio.po.FloorPo;
import com.gio.po.HouseVo;
import com.gio.po.Position;

public interface WarningMapper {
	public List<HouseVo> getWarnedHouse(String date);
	public List<HouseVo> getRentalWarnedHouseByBid(int bid);

	public List<Integer> getWarnedFloor(FloorPo fp);
	public List<Integer> getWarnedHouseByFloor(Position p);
}

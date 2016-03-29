package com.gio.mapper;

import java.util.List;

import com.gio.po.HouseMsg;
import com.gio.po.Names;
import com.gio.po.Position;
import com.gio.vo.HouseQueryVo;

public interface HouseQueryMapper {
	public List<HouseQueryVo> QueryHouseByNames(Names names);
	public List<HouseMsg> getHouseMsg(Position p);
}

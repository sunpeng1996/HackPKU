package com.gio.mapper;

import java.util.List;

import com.gio.vo.BuildingTaxCountVo;
import com.gio.vo.TaxIncome;

public interface BuildingQueryMapper {
	public List<BuildingTaxCountVo> getBuildingTaxCountVoByYear(int year);
	public List<BuildingTaxCountVo> getBuildingTaxCountVoByBuilding(int bid);
	public List<TaxIncome> getTaxIncome(int bid);
}

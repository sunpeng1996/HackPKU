package com.gio.po;

import java.util.Map;

public class BuildingUsageState {
	private Building building;
	private Map<String,Float> houseUsage;
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public Map<String, Float> getHouseUsage() {
		return houseUsage;
	}
	public void setHouseUsage(Map<String, Float> houseUsage) {
		this.houseUsage = houseUsage;
	}
	@Override
	public String toString() {
		return "BuildingUsageState [building=" + building + ", houseUsage="
				+ houseUsage + "]";
	}
	
	
}

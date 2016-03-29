package com.gio.po;

public class FloorPo {
	private String timestamp;
	private Integer floor;
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	@Override
	public String toString() {
		return "FloorPo [timestamp=" + timestamp + ", floor=" + floor + "]";
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}

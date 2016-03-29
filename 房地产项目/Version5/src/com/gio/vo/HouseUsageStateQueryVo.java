package com.gio.vo;

public class HouseUsageStateQueryVo {
	private String usage;
	private int count;
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "HouseUsageStateQueryVo [usage=" + usage + ", count=" + count
				+ "]";
	}
	
}

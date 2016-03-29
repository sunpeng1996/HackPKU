package com.gio.po;

public class Building {
	private int bid;
	private String bname;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	@Override
	public String toString() {
		return "Building [bid=" + bid + ", bname=" + bname + "]";
	}
	public Building(int bid, String bname) {
		super();
		this.bid = bid;
		this.bname = bname;
	}
	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

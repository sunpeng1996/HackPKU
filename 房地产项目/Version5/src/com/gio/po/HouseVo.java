package com.gio.po;

public class HouseVo {
	private int hid;
	private String fybh;
	private String usage;
	private String floor;
	private String fanghao;
	private String owner_name;
	private String date_end;
	private Float rent_money_per_square;
	private Integer square;
	private Float rent_money;
	
	public Float getRent_money_per_square() {
		return rent_money_per_square;
	}
	public void setRent_money_per_square(Float rent_money_per_square) {
		this.rent_money_per_square = rent_money_per_square;
	}
	public Integer getSquare() {
		return square;
	}
	public void setSquare(Integer square) {
		this.square = square;
	}
	public Float getRent_money() {
		return rent_money;
	}
	public void setRent_money(Float rent_money) {
		this.rent_money = rent_money;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getFybh() {
		return fybh;
	}
	public void setFybh(String fybh) {
		this.fybh = fybh;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getFanghao() {
		return fanghao;
	}
	public void setFanghao(String fanghao) {
		this.fanghao = fanghao;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
}

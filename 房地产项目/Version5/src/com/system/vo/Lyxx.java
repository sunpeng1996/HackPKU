package com.system.vo;

public class Lyxx {

	int id;//int(11)楼宇基础信息id
	String lymc;//varchar(500)楼宇名称
	String lyzts;//varchar(500)楼宇总套数
	String lydz;//varchar(500)楼宇坐落地址
	int swjg_id;//int(11)所属税务机关ID
	String xzqh;//varchar(500)行政区划
	String fwscjx;//varchar(500)房屋所处街乡
	public String getFwscjx() {
		return fwscjx;
	}
	public void setFwscjx(String fwscjx) {
		this.fwscjx = fwscjx;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLydz() {
		return lydz;
	}
	public void setLydz(String lydz) {
		this.lydz = lydz;
	}
	public String getLymc() {
		return lymc;
	}
	public void setLymc(String lymc) {
		this.lymc = lymc;
	}
	public String getLyzts() {
		return lyzts;
	}
	public void setLyzts(String lyzts) {
		this.lyzts = lyzts;
	}
	public int getSwjg_id() {
		return swjg_id;
	}
	public void setSwjg_id(int swjg_id) {
		this.swjg_id = swjg_id;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

}

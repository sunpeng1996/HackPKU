package com.gio.vo;

public class BuildingTaxCountVo {
	private String bname;
	private Integer year;
	private float jan;
	private float feb;
	private float mar;
	private float apri;
	private float may;
	private float june;
	private float july;
	private float aug;
	private float sept;
	private float oct;
	private float nov;
	private float dec;
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public float getJan() {
		return jan;
	}
	public void setJan(float jan) {
		this.jan = jan;
	}
	public float getFeb() {
		return feb;
	}
	public void setFeb(float feb) {
		this.feb = feb;
	}
	public float getMar() {
		return mar;
	}
	public void setMar(float mar) {
		this.mar = mar;
	}
	public float getApri() {
		return apri;
	}
	public void setApri(float apri) {
		this.apri = apri;
	}
	public float getMay() {
		return may;
	}
	public void setMay(float may) {
		this.may = may;
	}
	public float getJune() {
		return june;
	}
	public void setJune(float june) {
		this.june = june;
	}
	public float getJuly() {
		return july;
	}
	public void setJuly(float july) {
		this.july = july;
	}
	public float getAug() {
		return aug;
	}
	public void setAug(float aug) {
		this.aug = aug;
	}
	public float getSept() {
		return sept;
	}
	public void setSept(float sept) {
		this.sept = sept;
	}
	public float getOct() {
		return oct;
	}
	public void setOct(float oct) {
		this.oct = oct;
	}
	public float getNov() {
		return nov;
	}
	public void setNov(float nov) {
		this.nov = nov;
	}
	public float getDec() {
		return dec;
	}
	public void setDec(float dec) {
		this.dec = dec;
	}
	@Override
	public String toString() {
		return "BuildingTaxCountVo [bname=" + bname + ", jan=" + jan + ", feb="
				+ feb + ", mar=" + mar + ", apri=" + apri + ", may=" + may
				+ ", june=" + june + ", july=" + july + ", aug=" + aug
				+ ", sept=" + sept + ", oct=" + oct + ", nov=" + nov + ", dec="
				+ dec + "]";
	}
	
}

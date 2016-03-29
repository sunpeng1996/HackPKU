package com.system.vo;

public class Card {
	int id;//int(11)证件种类表id
	String cardname;//varchar(200)证件名称
	String remark;//varchar(200)备注
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

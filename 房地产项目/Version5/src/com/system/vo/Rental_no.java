package com.system.vo;

public class Rental_no {
	int id;//int(11)2.3.房产使用信息_非出租 id
	String data_2;//varchar(255)2)房间ID：外键
	String data_3;//varchar(255)3)*时间戳：更新时间
	String data_4;//varchar(255)4)*操作人：当前操作的系统用户
	String data_5;//varchar(255)5)*是否有效： 加索引 当主表“房屋基础信息”字段房产使用类型变为“承租”时，此标记为0。当“使用者名称、使用者证件号码、使用类型”发生变化时，标记位置0，并新生成复制的纪录；
	String data_6;//varchar(255)6)*使用者名称： 字符串
	int data_7;//int(11)7)*使用者证件类型ID： 外键
	String data_8;//varchar(255)8)使用者证件号码： 字符串
	String data_9;//varchar(255)*使用类型：正常自用、无租使用、承典、融资租赁、闲置；
	String data_10;//varchar(255)10)使用面积：
	String data_11;//varchar(255)11)*使用者是否征收房产税：
	String data_12;//varchar(255)12)*征收品目：
	String data_13;//varchar(255)13)*房产原值（元） 不得大于“房产总原值（元）”
	String data_14;//varchar(255)14)*免税原值（元）
	String data_15;//varchar(255)15)*应税原值（元）
	String data_16;//varchar(255)16)*有效期起 有条件非空约束 日期类型 加索引 不得小于“权属有效期起”
	String data_17;//varchar(255)17)*有效期止 有条件非空约束 日期类型 加索引
	String data_18;//varchar(255)18)备注：
	String data_19;//varchar(255)19)*房产税纳税人：
	int data_20;//int(11)20)*房产税纳税人证件类型：
	String data_21;//varchar(255)21)*房产税纳税人证件号码
	String data_22;//varchar(255)22)年应纳税额（元）： =（房产原值-免税原值）*（1-30%）*0.012
	String data_23;//varchar(255)23)*纳税期限：
	public String getData_10() {
		return data_10;
	}
	public void setData_10(String data_10) {
		this.data_10 = data_10;
	}
	public String getData_11() {
		return data_11;
	}
	public void setData_11(String data_11) {
		this.data_11 = data_11;
	}
	public String getData_12() {
		return data_12;
	}
	public void setData_12(String data_12) {
		this.data_12 = data_12;
	}
	public String getData_13() {
		return data_13;
	}
	public void setData_13(String data_13) {
		this.data_13 = data_13;
	}
	public String getData_14() {
		return data_14;
	}
	public void setData_14(String data_14) {
		this.data_14 = data_14;
	}
	public String getData_15() {
		return data_15;
	}
	public void setData_15(String data_15) {
		this.data_15 = data_15;
	}
	public String getData_16() {
		return data_16;
	}
	public void setData_16(String data_16) {
		this.data_16 = data_16;
	}
	public String getData_17() {
		return data_17;
	}
	public void setData_17(String data_17) {
		this.data_17 = data_17;
	}
	public String getData_18() {
		return data_18;
	}
	public void setData_18(String data_18) {
		this.data_18 = data_18;
	}
	public String getData_19() {
		return data_19;
	}
	public void setData_19(String data_19) {
		this.data_19 = data_19;
	}
	public String getData_2() {
		return data_2;
	}
	public void setData_2(String data_2) {
		this.data_2 = data_2;
	}
	public int getData_20() {
		return data_20;
	}
	public void setData_20(int data_20) {
		this.data_20 = data_20;
	}
	public String getData_21() {
		return data_21;
	}
	public void setData_21(String data_21) {
		this.data_21 = data_21;
	}
	public String getData_22() {
		return data_22;
	}
	public void setData_22(String data_22) {
		this.data_22 = data_22;
	}
	public String getData_23() {
		return data_23;
	}
	public void setData_23(String data_23) {
		this.data_23 = data_23;
	}
	public String getData_3() {
		return data_3;
	}
	public void setData_3(String data_3) {
		this.data_3 = data_3;
	}
	public String getData_4() {
		return data_4;
	}
	public void setData_4(String data_4) {
		this.data_4 = data_4;
	}
	public String getData_5() {
		return data_5;
	}
	public void setData_5(String data_5) {
		this.data_5 = data_5;
	}
	public String getData_6() {
		return data_6;
	}
	public void setData_6(String data_6) {
		this.data_6 = data_6;
	}
	public int getData_7() {
		return data_7;
	}
	public void setData_7(int data_7) {
		this.data_7 = data_7;
	}
	public String getData_8() {
		return data_8;
	}
	public void setData_8(String data_8) {
		this.data_8 = data_8;
	}
	public String getData_9() {
		return data_9;
	}
	public void setData_9(String data_9) {
		this.data_9 = data_9;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

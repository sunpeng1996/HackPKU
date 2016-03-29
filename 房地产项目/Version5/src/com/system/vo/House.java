package com.system.vo;

public class House {

	int id;//int(11)房屋信息表id
	int data_2;//int(11)2)楼宇ID：外键
	String data_3;//varchar(50)房产使用类型：
	String data_4;//varchar(50)楼层: 数字 （非空）
	String data_5;//varchar(50)5)房号：字符串存储的数字（非空）
	String data_6;//varchar(100)6)房源编号：
	String data_7;//varchar(100)7)产权证书号：UNIQUE 约束
	String data_8;//varchar(100)8)土地税源编号：
	String data_9;//varchar(50)9)*房产总原值（元）：
	String data_10;//varchar(50)10)*房屋面积（平方米）：
	String data_11;//varchar(50)11)*权属有效期起：日期
	String data_12;//varchar(50)12)房产证书持有人识别号：
	String data_13;//varchar(50)房产证书持有人名称：
	int data_14;//int(11)14)房产证书持有人证件类型ID：外键
	String data_15;//varchar(50)15)房产证书持有人证件号码：
	String data_16;//varchar(50)是否有效：如果房产证书持有人变更，置为无效；
	String data_18;//varchar(500)18 房屋所在地址
	String data_19;//varchar(50)19 所属税务机关
	String data_20;//varchar(50)20 行政区划
	String data_21;//varchar(500)21 房屋所处街乡
	String data_17;//varchar(50)17)*权属有效期止：日期
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
	public int getData_14() {
		return data_14;
	}
	public void setData_14(int data_14) {
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
	public int getData_2() {
		return data_2;
	}
	public void setData_2(int data_2) {
		this.data_2 = data_2;
	}
	public String getData_20() {
		return data_20;
	}
	public void setData_20(String data_20) {
		this.data_20 = data_20;
	}
	public String getData_21() {
		return data_21;
	}
	public void setData_21(String data_21) {
		this.data_21 = data_21;
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
	public String getData_7() {
		return data_7;
	}
	public void setData_7(String data_7) {
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

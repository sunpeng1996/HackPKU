package com.system.vo;

public class Rental_yes {
	

	int id;//int(11)2.3.房产使用信息_非出租 id
	String data_2;//varchar(255)2)房间ID：外键
	String data_3;//varchar(255)3)*时间戳：更新时间
	String data_4;//varchar(255)4)*操作人：当前操作的系统用户
	String data_5;//varchar(255)5)*是否有效： 加索引 当主表“房屋基础信息”字段房产使用类型变为“承租”时，此标记为0。当“使用者名称、使用者证件号码、使用类型”发生变化时，标记位置0，并新生成复制的纪录；
	String data_6;//varchar(255)6)*使用者名称： 字符串
	String data_7;//varchar(255)7)*使用者证件类型ID： 外键
	String data_8;//varchar(255)8)使用者证件号码： 字符串
	String data_9;//varchar(255)9)*使用者使用类型：承租
	String data_10;//varchar(255)10)使用面积：
	String data_11;//varchar(255)11)*使用者是否征收房产税：
	String data_12;//varchar(255)12)出租人名称：
	int data_13;//int(11)13)出租人身份证件种类：
	String data_14;//varchar(255)14)出租人证件号码：
	String data_15;//varchar(255)15)出租面积
	String data_16;//varchar(255)16)出租人使用类型： 出租
	String data_17;//varchar(255)17)*出租者是否征收房产税：
	String data_18;//varchar(255)18)*征收品目 ： “其他房屋出租“
	String data_19;//varchar(255)19)*年租金收入（元）：
	String data_20;//varchar(255)20)*有效期起（注：出租起始时间） 有条件非空约束 日期类型 加索引
	String data_21;//varchar(255)21)*有效期止（注：出租截止时间） 日期类型 加索引
	String data_22;//varchar(255)22)备注
	String data_23;//varchar(255)23)*房产税纳税人：
	int data_24;//int(11)24)*房产税纳税人证件类型：
	String data_25;//varchar(255)25)*房产税纳税人证件号码
	String data_26;//varchar(255)26)*年应纳税额（元）（注：出租）（注：“年应纳税额”是“年租金收入”*“征收品目”对应税率计算出来的。“个人出租住房”对应税率是0.04，“其他房屋出租”对应税率是0.12.）
	String data_27;//varchar(255)27)*纳税期限：
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
	public int getData_13() {
		return data_13;
	}
	public void setData_13(int data_13) {
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
	public int getData_24() {
		return data_24;
	}
	public void setData_24(int data_24) {
		this.data_24 = data_24;
	}
	public String getData_25() {
		return data_25;
	}
	public void setData_25(String data_25) {
		this.data_25 = data_25;
	}
	public String getData_26() {
		return data_26;
	}
	public void setData_26(String data_26) {
		this.data_26 = data_26;
	}
	public String getData_27() {
		return data_27;
	}
	public void setData_27(String data_27) {
		this.data_27 = data_27;
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

package com.system.vo;

import java.util.List;

/**
 * ==================================
 * 实体类 - 系统管理 - 菜单管理 
 * ----------------------------------
 * 
 * ==================================
 */
 
public class Menu {

	private int id;//int(11)
	private String menuname;//varchar(500)菜单名称
	private String menuurl;//varchar(500)菜单地址
	private int pid;//int(11)父菜单id
	private int isfather;//int(11)1：一级菜单 2：二级菜单
	private String remark;//varchar(500)备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIsfather() {
		return isfather;
	}
	public void setIsfather(int isfather) {
		this.isfather = isfather;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}





}
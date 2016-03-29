package com.system.vo;


public class Role{
	
	int id;//int(11)角色表id
	String rolename;//varchar(50)角色名称
	String remark;//varchar(500)备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	


	
}
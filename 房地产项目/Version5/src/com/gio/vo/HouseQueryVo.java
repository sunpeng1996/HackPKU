package com.gio.vo;

public class HouseQueryVo {
	private int th_id;
	private int th_lyid;
	private String owner_name;
	private String user_name;
	private String rental_name;
	
	private int owner_idtype;
	private int user_idtype;
	private int rental_idtype;
	private String owner_id;
	private String user_id;
	private String rental_id;
	
	private String usage_type;
	public String getUsage_type() {
		return usage_type;
	}
	public void setUsage_type(String usage_type) {
		this.usage_type = usage_type;
	}
	public int getOwner_idtype() {
		return owner_idtype;
	}
	public void setOwner_idtype(int owner_idtype) {
		this.owner_idtype = owner_idtype;
	}
	public int getUser_idtype() {
		return user_idtype;
	}
	public void setUser_idtype(int user_idtype) {
		this.user_idtype = user_idtype;
	}
	public int getRental_idtype() {
		return rental_idtype;
	}
	public void setRental_idtype(int rental_idtype) {
		this.rental_idtype = rental_idtype;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRental_id() {
		return rental_id;
	}
	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}
	public int getTh_id() {
		return th_id;
	}
	public void setTh_id(int th_id) {
		this.th_id = th_id;
	}
	public int getTh_lyid() {
		return th_lyid;
	}
	public void setTh_lyid(int th_lyid) {
		this.th_lyid = th_lyid;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRental_name() {
		return rental_name;
	}
	public void setRental_name(String rental_name) {
		this.rental_name = rental_name;
	}
	@Override
	public String toString() {
		return "HouseQueryVo [th_id=" + th_id + ", th_lyid=" + th_lyid
				+ ", owner_name=" + owner_name + ", user_name=" + user_name
				+ ", rental_name=" + rental_name + ", owner_idtype="
				+ owner_idtype + ", user_idtype=" + user_idtype
				+ ", rental_idtype=" + rental_idtype + ", owner_id=" + owner_id
				+ ", user_id=" + user_id + ", rental_id=" + rental_id + "]";
	}
	
	
	
}

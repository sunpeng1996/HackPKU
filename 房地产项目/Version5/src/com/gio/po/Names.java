package com.gio.po;

public class Names {
	private String owner_name;
	private String user_name;
	private String rental_name;
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
		return "Names [owner_name=" + owner_name + ", user_name=" + user_name
				+ ", rental_name=" + rental_name + "]";
	}
	public Names(String owner_name, String user_name, String rental_name) {
		super();
		this.owner_name = owner_name;
		this.user_name = user_name;
		this.rental_name = rental_name;
	}
	
}

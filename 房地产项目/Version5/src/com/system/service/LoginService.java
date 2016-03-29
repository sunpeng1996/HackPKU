package com.system.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.system.vo.User;

@Component
public interface LoginService {
	User login(String username, String userpass);
	User fnUser(String username);
	
	public List get_menu(String user_id);

	public List get_list_menu_my(String user_id);

	public List getSection(String type_id);

	public List getSensor(String type_id);

	public List getSs(String sensor_id);
	public List getYjz(String sensor_id);
}

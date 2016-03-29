package com.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.system.service.LoginService;
import com.system.vo.User;

/**
 * ==================================
 * 控制器 - 登录
 * ----------------------------------
 * 
 * ==================================
 */
 
@Component
@RequestMapping("")
@Scope("prototype")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/*
	 * 用户登录
	 */
	@RequestMapping(value = "login")
	public void login(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "username", defaultValue = "") String username,
			@RequestParam(value = "userpass", defaultValue = "") String userpass)
			throws IOException {

		if ("".equals(username) && "".equals(userpass)) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		PrintWriter pw = response.getWriter();
		User fnUser = loginService.fnUser(username);
		if (fnUser == null) {
			pw.print("un");
		} else {
			if (!fnUser.getLoginpass().equals(userpass)) {
				pw.write("pn");
			} else {
				User user = loginService.login(username, userpass);
				request.getSession().removeAttribute("user");
				request.getSession().setAttribute("user", user);
				pw.write("y");
			}
		}
		pw.flush();
	}

	/*
	 * 退出登录
	 */
	@RequestMapping(value = "logout")
	public void logout(HttpServletRequest request, HttpServletResponse response)throws IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath());
	}
}
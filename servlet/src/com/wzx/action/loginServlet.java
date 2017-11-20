package com.wzx.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.UserDto;
import com.wzx.service.UserService;
import com.wzx.service.inter.IUserService;

public class loginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		UserDto user = new UserDto();
		user.setName(name);
		user.setPwd(pwd);
		IUserService us = new UserService();
		user = us.loginUser(user);
		if (user != null) {
			Cookie nameC = new Cookie("nameC", URLEncoder.encode(name, "utf-8"));
			Cookie pwdC = new Cookie("pwdC", pwd);
			// 设置cookie失效时间
			nameC.setMaxAge(24 * 60 * 60);
			pwdC.setMaxAge(24 * 60 * 60);
			// 设置cookie保存路径
			nameC.setPath("/servlet");
			pwdC.setPath("/servlet");
			// 放到相应对象中
			res.addCookie(nameC);
			res.addCookie(pwdC);
			req.getSession().setAttribute("user", user);
			res.sendRedirect("newsList.do");
		} else {
			req.getSession().setAttribute("error", "账号或者密码错误");
			res.sendRedirect("index.jsp");
		}
	}

}

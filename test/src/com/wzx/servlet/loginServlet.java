package com.wzx.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.Employee;
import com.wzx.service.EmService;
import com.wzx.service.inter.IEmService;

public class loginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name = req.getParameter("ename");//从登录页面获取账号，密码
		String pwd = req.getParameter("epad");
		Employee ee = new Employee();
		ee.setEname(name);
		ee.setEpad(pwd);
		IEmService es = new EmService();
		ee = es.login(ee);//调用登录方法
		if (ee != null) {
			//判断并保存cookie
			Cookie nameC = new Cookie("nameC", URLEncoder.encode(name, "utf-8"));
			Cookie pwdC = new Cookie("pwdC", pwd);
			// 设置cookie失效时间
			nameC.setMaxAge(24 * 60 * 60);
			pwdC.setMaxAge(24 * 60 * 60);
			// 设置cookie保存路径
			nameC.setPath("/test");
			pwdC.setPath("/test");
			// 放到相应对象中
			res.addCookie(nameC);
			res.addCookie(pwdC);
			req.getSession().setAttribute("ee", ee);//对象置于session
			res.sendRedirect("info.do");
		} else {
			req.getSession().setAttribute("error", "账号或者密码错误");
			res.sendRedirect("index.jsp");
		}
	}

}

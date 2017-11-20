package com.wzx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.Employee;
import com.wzx.service.EmService;
import com.wzx.service.inter.IEmService;

public class reg extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IEmService es=new EmService();
		Employee ee=new Employee();
		ee.setEname(req.getParameter("name"));
		ee.setEpad(req.getParameter("pwd"));
		es.reg(ee);
		resp.sendRedirect("index.jsp");
	}

}

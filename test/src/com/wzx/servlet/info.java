package com.wzx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.Employee;
import com.wzx.dto.Query;
import com.wzx.service.EmService;
import com.wzx.service.inter.IEmService;

public class info extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IEmService es=new EmService();
		Query query=new Query();
		query.setQname(req.getParameter("ename"));
		query.setQdate(req.getParameter("edate"));
		List<Employee> ep=es.eList(query);
		req.getSession().setAttribute("q", query);
		req.getSession().setAttribute("ep", ep);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
	
}

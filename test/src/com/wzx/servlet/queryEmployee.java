package com.wzx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.Employee;
import com.wzx.service.EmService;
import com.wzx.service.inter.IEmService;

public class queryEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IEmService es=new EmService();
		Employee ee=es.query(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("ee", ee);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

}

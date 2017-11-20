package com.wzx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.Employee;
import com.wzx.service.EmService;
import com.wzx.service.inter.IEmService;

public class check extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String message="";
		IEmService es=new EmService();
		Employee ee=new Employee();
		ee=es.check(req.getParameter("name"));
		if(ee!=null){//有重复用户名
			message="{\"meg\":false}";
		}else{
			message="{\"meg\":true}";
		}
		PrintWriter pw=resp.getWriter();
		pw.write(message);
		pw.flush();
		pw.close();
	}

}

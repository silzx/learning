package com.wzx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.ProvinceDto;
import com.wzx.service.ProvinceService;
import com.wzx.service.inter.IProvinceService;

public class ProvinceServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IProvinceService ps=new ProvinceService();
		List<ProvinceDto> pros=ps.getProvince();
		req.setAttribute("pros", pros);
		req.getRequestDispatcher("city.jsp").forward(req, resp);
	}
}

package com.wzx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.wzx.dto.CityDto;
import com.wzx.service.CityService;
import com.wzx.service.inter.ICityService;

public class getCity extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			ICityService cs=new CityService();
			String proname=req.getParameter("proname");
			List<CityDto> citys=cs.getCity(proname);
			JSONArray city=JSONArray.fromObject(citys);
			resp.getWriter().write(city.toString());
			resp.getWriter().flush();
			resp.getWriter().close();
	}

}

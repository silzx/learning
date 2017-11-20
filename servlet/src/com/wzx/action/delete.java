package com.wzx.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.service.NewsService;
import com.wzx.service.inter.INewsService;

/**
 * Servlet implementation class delete
 */
public class delete extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		INewsService ns=new NewsService();
		String ids[] =req.getParameterValues("single");
		if(ids!=null){
			for(String id:ids){
				ns.del(id);
			}
		}else{
			ns.del(req.getParameter("id"));
		}
		res.sendRedirect("newsList.do");
	}

}

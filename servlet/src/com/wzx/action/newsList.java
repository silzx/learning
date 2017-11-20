package com.wzx.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.service.FenYeService;
import com.wzx.service.NewsService;
import com.wzx.service.inter.IFenYeService;
import com.wzx.service.inter.INewsService;

/**
 * Servlet implementation class newsList
 */
public class newsList extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String qtitle="";
		String qcontext="";
		INewsService ns=new NewsService();
		IFenYeService fs=new FenYeService();
		Map<String,String> se=new HashMap<String,String>();
		se.put("qtitle", req.getParameter("qtitle"));
		se.put("qcontext",req.getParameter("qcontext"));
		FenYe.search=se;
		if(req.getParameter("qtitle")!=null){
			qtitle=req.getParameter("qtitle");
		}
		if(req.getParameter("qcontext")!=null){
			qcontext=req.getParameter("qcontext");
		}
		String pag=req.getParameter("page");
		FenYe.fy=fs.getFenYe(FenYe.fy, pag);
		List<NewsDto> news=ns.queryByFenYe(FenYe.fy);
		req.setAttribute("qtitle", qtitle);
		req.setAttribute("qcontext", qcontext);
		req.getSession().setAttribute("news", news);
		req.getRequestDispatcher("admin/main.jsp").forward(req, res);
	}

}

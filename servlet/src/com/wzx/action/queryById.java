package com.wzx.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.dto.NewsDto;
import com.wzx.service.NewsService;
import com.wzx.service.inter.INewsService;

/**
 * Servlet implementation class queryById
 */
public class queryById extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		INewsService ns = new NewsService();
		NewsDto n = ns.queryById(req.getParameter("id"));
		req.setAttribute("n", n);
		req.getRequestDispatcher("update.jsp").forward(req, res);
	}

}

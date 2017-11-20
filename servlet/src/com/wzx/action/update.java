package com.wzx.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wzx.dto.NewsDto;
import com.wzx.service.FileUploadService;
import com.wzx.service.NewsService;
import com.wzx.service.inter.IFileUploadService;
import com.wzx.service.inter.INewsService;

/**
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		INewsService ns = new NewsService();
		IFileUploadService ifs=new FileUploadService();
		NewsDto news = new NewsDto();
		DiskFileItemFactory dis = new DiskFileItemFactory();
		ServletFileUpload sf = new ServletFileUpload(dis);
		// news.setPic(null);
		List<FileItem> up;
		try {
			up = sf.parseRequest(req);
			news=ifs.getNews(up);
			ns.update(news);
			res.sendRedirect("newsList.do");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}

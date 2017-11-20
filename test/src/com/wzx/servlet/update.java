package com.wzx.servlet;

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

import com.wzx.dto.Employee;
import com.wzx.service.EmService;
import com.wzx.service.FileUploadService;
import com.wzx.service.inter.IEmService;
import com.wzx.service.inter.IFileUploadService;

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
		IEmService es = new EmService();
		IFileUploadService ifs=new FileUploadService();
		Employee ee = new Employee();
		DiskFileItemFactory dis = new DiskFileItemFactory();
		ServletFileUpload sf = new ServletFileUpload(dis);
		List<FileItem> up;
		try {
			up = sf.parseRequest(req);
			ee=ifs.getEe(up);
			es.update(ee);
			res.sendRedirect("info.do");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}

}

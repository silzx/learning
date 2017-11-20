package com.wzx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.service.EmService;
import com.wzx.service.inter.IEmService;

public class delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IEmService es=new EmService();
		String ids[] =req.getParameterValues("single");//获取JSP页面中所有被选中的ID
		if(ids==null){//只删除一个
			es.delete(Integer.parseInt(req.getParameter("id")));
		}else{
			for(String id:ids){//如果为多个则遍历删除
				es.delete(Integer.parseInt(id));
			}
		}
		resp.sendRedirect("info.do");
	}

}

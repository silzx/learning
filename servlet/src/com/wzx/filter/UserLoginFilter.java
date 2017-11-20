package com.wzx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("登录过滤器销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse res=(HttpServletResponse) arg1;
		//System.out.println(req.getSession().getAttribute("user"));
		//System.out.println(req.getServletPath());\
		if(req.getSession().getAttribute("user")!=null || "/loginServlet.do".equals(req.getServletPath()) || "/index.jsp".equals(req.getServletPath())){
			arg2.doFilter(arg0, arg1);
		}else{
			String path=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
			req.getSession().setAttribute("error", "非法请求，请登录！");
			res.sendRedirect(path+"index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("登录过滤器创建");
	}

}

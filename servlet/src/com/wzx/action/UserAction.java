package com.wzx.action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.UserDto;
import com.wzx.service.UserService;
import com.wzx.service.inter.IUserService;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements SessionAware{
	private UserDto u;
	private IUserService us = new UserService();
	private Map<String,Object> session;
	public String userLogin(){
		String flag="error";
		UserDto user = us.loginUser(u);
		try {
			if (user != null) {
				Cookie nameC = new Cookie("nameC", URLEncoder.encode(user.getName(), "utf-8"));
				Cookie pwdC = new Cookie("pwdC", user.getPwd());
				// 设置cookie失效时间
				nameC.setMaxAge(24 * 60 * 60);
				pwdC.setMaxAge(24 * 60 * 60);
				// 设置cookie保存路径
				nameC.setPath("/servlet");
				pwdC.setPath("/servlet");
				// 放到相应对象中
				ServletActionContext.getResponse().addCookie(nameC);
				ServletActionContext.getResponse().addCookie(pwdC);
				session.put("user", user);
				flag="success";
			} else {
				session.put("error", "账号或者密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public UserDto getU() {
		return u;
	}
	public void setU(UserDto u) {
		this.u = u;
	}
	
}

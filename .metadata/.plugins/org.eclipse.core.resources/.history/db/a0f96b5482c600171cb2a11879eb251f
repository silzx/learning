package com.wzx.Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wzx.Dto.UserDto;

public class UserAction extends ActionSupport {
	private UserDto user;
	private String a;
	public String userLogin(){
		a="拥有get/set方法的全局变量默认置于request作用域中";
		Map<String,Object>session=ActionContext.getContext().getSession();
		session.put("session", "session value");
		Map<String,Object>app=ActionContext.getContext().getApplication();
		app.put("application", "application value");
		Map<String,Object>req=(Map<String, Object>) ActionContext.getContext().get("request");
		req.put("request", "request value");
		System.out.println(user.toString());
		return SUCCESS;
	}
	
	
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
	
	
}

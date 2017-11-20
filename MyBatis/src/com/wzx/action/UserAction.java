package com.wzx.action;

import java.net.URLEncoder;
import java.util.HashMap;
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
	private Map<String,Object> json=new HashMap<String,Object>();
	public String userLogin(){
		String flag="error";
		UserDto user = us.login(u);
		try {
			if (user != null) {
				Cookie nameC = new Cookie("nameC", URLEncoder.encode(user.getName(), "utf-8"));
				Cookie pwdC = new Cookie("pwdC", user.getPwd());
				// 设置cookie失效时间
				nameC.setMaxAge(24 * 60 * 60);
				pwdC.setMaxAge(24 * 60 * 60);
				// 设置cookie保存路径
				nameC.setPath("/MyBatis");
				pwdC.setPath("/MyBatis");
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
	
	public String regsiter(){
		us.reg(u);
		return "regsiter";
	}
	
	public String regName(){
		if(us.regName(u.getName())!=null){
			json.put("meg", true);
		}else{
			json.put("meg", false);
		}
		return "regName";
	}
	
	public String exit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public Map<String, Object> getJson() {
		return json;
	}

	public void setJson(Map<String, Object> json) {
		this.json = json;
	}

	public UserDto getU() {
		return u;
	}
	public void setU(UserDto u) {
		this.u = u;
	}

	public IUserService getUs() {
		return us;
	}

	public void setUs(IUserService us) {
		this.us = us;
	}
	
}

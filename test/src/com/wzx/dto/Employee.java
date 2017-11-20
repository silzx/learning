package com.wzx.dto;

import java.util.Date;

public class Employee {
	private int id;//主键
	private int empid;//员工编号
	private String ename;//用户名
	private String epad;//密码
	private Date edate;//入职日期
	private String epic;//员工头像
	private String econtext;//员工简介
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpad() {
		return epad;
	}
	public void setEpad(String epad) {
		this.epad = epad;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getEpic() {
		return epic;
	}
	public void setEpic(String epic) {
		this.epic = epic;
	}
	public String getEcontext() {
		return econtext;
	}
	public void setEcontext(String econtext) {
		this.econtext = econtext;
	}
	
	
}	

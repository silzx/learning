package com.wzx.service.inter;

import java.util.List;

import com.wzx.dto.Employee;
import com.wzx.dto.Query;

public interface IEmService {
	public List<Employee> eList(Query query);//查询所有员工方法
	public Employee login(Employee e);//登录方法
	public int reg(Employee e);//注册方法
	public Employee check(String name);//根据用户名查询 是否有重复用户
	
	public Employee query(int id);////查询员工信息以便修改
	public int update(Employee e);//修改信息方法
	
	public int delete(int id);//删除方法
	
}

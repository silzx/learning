package com.wzx.service;

import java.util.List;

import com.wzx.dao.Eedao;
import com.wzx.dao.inter.IEeDao;
import com.wzx.dto.Employee;
import com.wzx.dto.Query;
import com.wzx.service.inter.IEmService;

public class EmService implements IEmService{
	private IEeDao ed=new Eedao();
	@Override
	public List<Employee> eList(Query query) {
		return ed.eList(query);
	}
	@Override
	public Employee login(Employee e) {
		return ed.login(e);
	}
	@Override
	public int update(Employee e) {
		return ed.update(e);
	}
	@Override
	public Employee query(int id) {
		return ed.query(id);
	}
	@Override
	public int reg(Employee e) {
		return ed.reg(e);
	}
	@Override
	public Employee check(String name) {
		return ed.check(name);
	}
	@Override
	public int delete(int id) {
		return ed.delete(id);
	}

}

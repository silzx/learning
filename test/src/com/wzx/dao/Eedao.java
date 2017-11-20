package com.wzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wzx.basedao.BaseDao;
import com.wzx.dao.inter.IEeDao;
import com.wzx.dto.Employee;
import com.wzx.dto.Query;
import com.wzx.util.DataSourceUtil;

public class Eedao extends BaseDao implements IEeDao{

	@Override
	public List<Employee> eList(Query query) {//模糊查询方法
		List<Object> args=new ArrayList<Object>();
		String sql="select * from employee where yes='yes'";//查询所有员工sql语句
		if(query.getQname()!=null && query.getQname()!=""){//判断是否有姓名模糊查询
			sql+=" and ename like ?";//拼接SQL语句
			args.add("%"+query.getQname()+"%");
		}
		if(query.getQdate()!=null && query.getQdate()!=""){//判断是否有日期模糊查询
			sql+=" and edate > ?";//拼接SQL语句
			args.add(String.valueOf(query.getQdate()));
		}
		return query(args, sql);
	}
	
	@Override
	public Employee login(Employee e) {//登录方法
		List<Object> args=new ArrayList<Object>();
		String sql="select * from employee where ename=? and epad=?";
		args.add(e.getEname());
		args.add(e.getEpad());
		List<Employee> em=query(args, sql);
		if(em.size()>0){
			return em.get(0);
		}
		return null;
	}
	
	@Override
	public int reg(Employee e) {//注册方法
		List<Object> args=new ArrayList<Object>();
		String sql="insert into employee(ename,epad) values(?,?)";
		args.add(e.getEname());
		args.add(e.getEpad());
		return update(args, sql);
	}
	
	
	@Override
	public int update(Employee e) {//修改员工信息方法
		List<Object> args=new ArrayList<Object>();
		String sql="update employee set empid=?";
		args.add(e.getEmpid());
		if(e.getEname()!=null && !"".equals(e.getEname())){
			sql+=",ename=?";
			args.add(e.getEname());
		}
		if(e.getEpad()!=null && !"".equals(e.getEpad())){
			sql+=",epad=?";
			args.add(e.getEpad());
		}
		if(e.getEdate()!=null && !"".equals(e.getEdate())){
			sql+=",edate=?";
			args.add(e.getEdate());
		}
		if(e.getEpic()!=null && !"".equals(e.getEpic())){
			sql+=",epic=?";
			args.add(e.getEpic());
		}
		if(e.getEcontext()!=null && !"".equals(e.getEcontext())){
			sql+=",econtext=?";
			args.add(e.getEcontext());
		}
		sql+=" where id=?";
		args.add(e.getId());
		return update(args, sql);
	}
	
	@Override
	public Employee query(int id) {//查询单个信息 以便后续修改
		List<Object> args=new ArrayList<Object>();
		String sql="select * from employee where id=?";
		args.add(id);
		List<Employee> ee=query(args, sql);
		if(ee.size()>0){
			return ee.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public Employee check(String name) {//检查重复用户名
		List<Object> args=new ArrayList<Object>();
		String sql="select * from employee where ename=?";
		args.add(name);
		List<Employee> ee=query(args, sql);
		if(ee.size()>0){
			return ee.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public int delete(int id) {
		List<Object> args=new ArrayList<Object>();
		String sql="update employee set yes='no' where id=?";
		args.add(id);
		return update(args, sql);
	}
	
	
	@Override
	public List<Employee> dispose(ResultSet rs) {//处理结果集
		List<Employee> em=new ArrayList<Employee>();
		try {
			while(rs.next()){
				Employee ee=new Employee();
				ee.setId(rs.getInt("id"));
				ee.setEmpid(rs.getInt("empid"));
				ee.setEname(rs.getString("ename"));
				ee.setEpad(rs.getString("epad"));
				ee.setEdate(rs.getDate("edate"));
				ee.setEpic(rs.getString("epic"));
				ee.setEcontext(rs.getString("econtext"));
				em.add(ee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.init().close(conn, rs, st);
		}
		return em;
	}
}

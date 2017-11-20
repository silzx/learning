package com.wzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wzx.basedao.BaseDao;
import com.wzx.dao.inter.IUserDao;
import com.wzx.dto.UserDto;

public class UserDao extends BaseDao implements IUserDao{

	@Override
	public UserDto loginUser(UserDto user) {
		List<Object> args=new ArrayList<Object>();
		String sql="select * from p_user where name=? and pwd=?";
		args.add(user.getName());
		args.add(user.getPwd());
		List<UserDto> us = query(args, sql);
		if(us.size()>0){
			return us.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public List<UserDto> dispose(ResultSet rs) {
		List<UserDto> us = new ArrayList<UserDto>();
		try {
			while(rs.next()){
				UserDto u = new UserDto();
				u.setAge(rs.getInt("age"));
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setNickname(rs.getString("nickname"));
				u.setPwd(rs.getString("pwd"));
				us.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return us;
	}
	
}

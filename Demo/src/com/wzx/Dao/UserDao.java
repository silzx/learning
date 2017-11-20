package com.wzx.Dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wzx.Dao.Inter.IUserDao;
import com.wzx.Dto.UserDto;

@Repository
public class UserDao implements IUserDao{
	@Autowired
	private SqlSessionTemplate sql;
	@Override
	public UserDto userLogin(String name, String pwd) {
		Map<String,String>login=new HashMap<String,String>();
		login.put("name", name);
		login.put("pwd", pwd);
		return sql.selectOne("userLogin",login);
	}

}

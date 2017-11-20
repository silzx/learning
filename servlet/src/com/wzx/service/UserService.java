package com.wzx.service;

import com.wzx.dao.UserDao;
import com.wzx.dao.inter.IUserDao;
import com.wzx.dto.UserDto;
import com.wzx.service.inter.IUserService;

public class UserService implements IUserService{
	private IUserDao ud = new UserDao();
	@Override
	public UserDto loginUser(UserDto user) {
		if(user.getName()==null||"".equals(user.getName())||user.getPwd()==null||"".equals(user.getPwd())){
			return null;
		}
		return ud.loginUser(user);
	}

}

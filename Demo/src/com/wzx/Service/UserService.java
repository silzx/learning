package com.wzx.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzx.Dao.Inter.IUserDao;
import com.wzx.Dto.UserDto;
import com.wzx.Service.Inter.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDao ud;
	@Override
	public UserDto userLogin(String name, String pwd) {
		return ud.userLogin(name, pwd);
	}

}

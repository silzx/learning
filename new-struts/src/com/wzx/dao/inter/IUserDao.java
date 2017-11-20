package com.wzx.dao.inter;

import com.wzx.dto.UserDto;

public interface IUserDao {
	public UserDto loginUser(UserDto user);
	public UserDto regName(String name);
	public int regsiter(UserDto u);
}

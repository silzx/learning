package com.wzx.service.inter;

import com.wzx.dto.UserDto;

public interface IUserService {
	public UserDto loginUser(UserDto user);
	public UserDto regName(String name);
	public int regsiter(UserDto u);
}

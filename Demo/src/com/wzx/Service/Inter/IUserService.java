package com.wzx.Service.Inter;

import com.wzx.Dto.UserDto;

public interface IUserService {
	public UserDto userLogin(String name,String pwd);
}

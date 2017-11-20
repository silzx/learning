package com.wzx.Dao.Inter;

import com.wzx.Dto.UserDto;

public interface IUserDao {
	public UserDto userLogin(String name,String pwd);
}

package com.wzx.dao.inter;

import java.util.List;

import com.wzx.dto.CityDto;

public interface ICityDao {
	public List<CityDto> citys(String proname);
}

package com.wzx.service;

import java.util.List;

import com.wzx.dao.CityDao;
import com.wzx.dao.inter.ICityDao;
import com.wzx.dto.CityDto;
import com.wzx.service.inter.ICityService;

public class CityService implements ICityService{
	ICityDao cd=new CityDao();
	@Override
	public List<CityDto> getCity(String proname) {
		return cd.citys(proname);
	}
	
}

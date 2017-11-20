package com.wzx.service.inter;

import java.util.List;

import com.wzx.dto.CityDto;

public interface ICityService {
	public List<CityDto> getCity(String proname);
}

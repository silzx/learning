package com.wzx.service;

import java.util.List;

import com.wzx.dao.ProvinceDao;
import com.wzx.dao.inter.IProvinceDao;
import com.wzx.dto.ProvinceDto;
import com.wzx.service.inter.IProvinceService;

public class ProvinceService implements IProvinceService{
	IProvinceDao pd=new ProvinceDao();
	@Override
	public List<ProvinceDto> getProvince() {
		return pd.provinceList();
	}

}

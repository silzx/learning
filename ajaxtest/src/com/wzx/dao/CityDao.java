package com.wzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wzx.basedao.BaseDao;
import com.wzx.dao.inter.ICityDao;
import com.wzx.dto.CityDto;

public class CityDao extends BaseDao implements ICityDao{

	@Override
	public List<CityDto> citys(String proname) {
		List<Object> args=new ArrayList<Object>();
		String sql="select cid,city_index,proid,cityname from(select * from province p,city c where p.pid=c.proid and proname=?)as pro";
		args.add(proname);
		List<CityDto> ct=query(args, sql);
		return ct;
	}

	@Override
	public List dispose(ResultSet rs) {
		List<CityDto> citys=new ArrayList<CityDto>();
		try {
			while(rs.next()){
				CityDto city=new CityDto();
				city.setCid(String.valueOf(rs.getInt("cid")));
				city.setCity_index(String.valueOf(rs.getInt("city_index")));
				city.setProid(String.valueOf(rs.getInt("proid")));
				city.setCityname(rs.getString("cityname"));
				citys.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return citys;
	}

}

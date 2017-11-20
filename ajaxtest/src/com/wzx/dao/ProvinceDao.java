package com.wzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wzx.basedao.BaseDao;
import com.wzx.dao.inter.IProvinceDao;
import com.wzx.dto.ProvinceDto;

public class ProvinceDao extends BaseDao implements IProvinceDao{

	@Override
	public List<ProvinceDto> provinceList() {
		List<Object> args=new ArrayList<Object>();
		String sql="select * from province";
		List<ProvinceDto> p=query(args, sql);
		if(p.size()>0){
			return p;
		}else{
			return null;
		}
	}

	@Override
	public List dispose(ResultSet rs) {
		List<ProvinceDto> p = new ArrayList<ProvinceDto>();
		try {
			while(rs.next()){
				ProvinceDto pro = new ProvinceDto();
				pro.setPid(rs.getString("pid"));
				pro.setProname(rs.getString("proname"));
				p.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}

package com.wzx.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wzx.util.DataSourceUtil;

public abstract class BaseDao {
	protected Connection conn=null;
	protected PreparedStatement st=null;
	protected ResultSet rs=null;
	public int update(List<Object> args,String sql){
		int flag=0;
		conn=DataSourceUtil.init().getConn();
		try {
			st=conn.prepareStatement(sql);
			if(args.size()>0){//如果参数列表有值
				for(int a=0;a<args.size();a++){
					st.setObject(a+1, args.get(a));
				}
			}
			flag=st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.init().close(conn, rs, st);
		}
		return flag;
	}
	
	
	public List query(List<Object> args,String sql){
		conn=DataSourceUtil.init().getConn();
		try {
			st=conn.prepareStatement(sql);
			if(args.size()>0){
				for(int i=0;i<args.size();i++){
					st.setObject(i+1, args.get(i));
				}
			}
			rs=st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dispose(rs);
	}
	
	
	public abstract List dispose(ResultSet rs);
}

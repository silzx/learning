package com.wzx.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DataSourceUtil {
	private DataSource ds=null;
	private Connection conn=null;
	private Context ct=null;
	private static DataSourceUtil dsu=new DataSourceUtil();
	
	public DataSourceUtil() {
		try {
			ct=new InitialContext();
			ds=(DataSource) ct.lookup("java:comp/env/jdbc/news");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public  static DataSourceUtil init(){
		return dsu;
	}
	
	
	public Connection getConn(){
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void close(Connection conn,ResultSet rs,PreparedStatement st){
		try {
			if(conn!=null){
				conn.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
		} catch (Exception e) {
		}
	}
}

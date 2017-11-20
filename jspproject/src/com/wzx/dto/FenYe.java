package com.wzx.dto;

import java.util.Map;

import com.wzx.dto.FenYe;

public class FenYe {
	public static int page;
	public static int pageCount;
	public static int row;
	public static int rowCount;
	public static int startRow;
	public static int endRow;
	public static Map<String,String> search;
	public static FenYe fy;
	public static void init(){
		fy=new FenYe();
	}
	public FenYe(){
		row=4;
		
		if(page==0){
			page=1;
		}
		
		if(rowCount%row==0){
			pageCount=rowCount/row;
		}else{
			pageCount=rowCount/row+1;
		}
		
		startRow=(page-1)*row;
		endRow=page*row;
	}
	
	
}

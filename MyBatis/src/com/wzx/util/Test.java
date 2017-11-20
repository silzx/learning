package com.wzx.util;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.service.FenYeService;
import com.wzx.service.NewsService;
import com.wzx.service.inter.IFenYeService;
import com.wzx.service.inter.INewsService;

public class Test extends ActionSupport{
	public  static void main(String[] args) {
		String pag=null;
		INewsService ns=new NewsService();
		IFenYeService fs=new FenYeService();
		FenYe fy=new FenYe();
		fy=fs.getFenYe(fy, pag);
		List<NewsDto> news=ns.queryNews(fy);
		for(NewsDto n:news){
			System.out.println(n.getTitle());
		}
	}

}

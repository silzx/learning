package com.wzx.dao;

import java.util.Date;
import java.util.List;

import com.wzx.dto.NewsDto;
import com.wzx.dto.Query;


public class TestJdbc {
	
	public static void main(String[] args) {
		NewsDao nd = new NewsDao();
//		NewsDto n = new NewsDto();
		Query query=new Query();
//		nd.del("1");
		
		List<NewsDto> news=nd.getAllNews();
		System.out.println(news.size());
//		for(NewsDto n:news){
//			System.out.println(n.toString());
//		}
//		nd.addNews("2" , "北京新闻", "北京", "zhangsan", "2017-10-10", "2.jpg");
//		nd.update("title", "成都新闻", 6);
//		nd.queryById(1);
//			
//		n.setNewsid(3);
//		n.setTitle("杭州新闻");
//		n.setContext("西湖");
//		n.setNewsman("cherry");
//		n.setNewsdate(new Date());
//		n.setPic("11.jpg");
//		List<NewsDto> ns=nd.addNews(n);
//		for(NewsDto news:ns){
//			System.out.println(news.toString());
//		}
//		
//		
//		query.setQtitle("新闻");
//		query.setQcontext("天气");
//		List<NewsDto> ns=nd.queryTitle(query);
//		System.out.println(ns.size()+"条查询结果");
//		NewsDto a=ns.get(0);
//		for(NewsDto news:ns){
//			System.out.println(news.toString());
//		}
		
		
		//根据ID修改
//		n.setId("9");
//		n.setNewsid(9);
//		n.setTitle("");
//		n.setContext("羊城晚报");
//		n.setNewsman("joshua");
//		n.setNewsdate(new Date());
//		n.setPic("8.jpg");
//		nd.update(n);
	}
}

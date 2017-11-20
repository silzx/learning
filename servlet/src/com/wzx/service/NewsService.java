package com.wzx.service;

import java.util.List;

import com.wzx.dao.NewsDao;
import com.wzx.dao.inter.INewsDao;
import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.dto.Query;
import com.wzx.service.inter.INewsService;

public class NewsService implements INewsService{
	private INewsDao nd = new NewsDao();
	@Override
	public int addNews(NewsDto n) {
		return nd.addNews(n);
	}

	@Override
	public int update(NewsDto n) {
		return nd.update(n);
	}

	@Override
	public int del(String id) {
		return nd.del(id);
	}

	@Override
	public List<NewsDto> getAllNews() {
		return nd.getAllNews();
	}

	@Override
	public List<NewsDto> queryTitle(Query query) {
		return nd.queryTitle(query);
	}

	@Override
	public NewsDto queryById(String id) {
		return nd.queryById(id);
	}

	@Override
	public List<NewsDto> queryByFenYe(FenYe fy) {
		return nd.queryByFenYe(fy);
	}

	@Override
	public int queryCount(FenYe fy) {
		return nd.queryCount(fy);
	}

}

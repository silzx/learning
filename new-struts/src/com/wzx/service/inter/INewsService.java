package com.wzx.service.inter;

import java.util.List;

import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.dto.Query;

public interface INewsService {
	public int addNews(NewsDto n);
	public int update(NewsDto n);
	public int del(String id);
	public List<NewsDto> getAllNews();
	public List<NewsDto> queryTitle(Query query);
	public NewsDto queryById(String id);
	public List<NewsDto> queryByFenYe(FenYe fy);
	public int queryCount(FenYe fy);
}

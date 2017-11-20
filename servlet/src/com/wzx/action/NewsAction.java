package com.wzx.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.service.FenYeService;
import com.wzx.service.NewsService;
import com.wzx.service.inter.IFenYeService;
import com.wzx.service.inter.INewsService;

public class NewsAction extends ActionSupport implements RequestAware,SessionAware{
	private Map<String, Object> request;
	private Map<String, Object> session;
	private INewsService ns=new NewsService();
	private IFenYeService fs=new FenYeService();
	public String queryNews(){
		String qtitle="";
		String qcontext="";
		String saveQtitle=ServletActionContext.getRequest().getParameter("qtitle");
		String saveQcontext=ServletActionContext.getRequest().getParameter("qcontext");
		Map<String,String> se=new HashMap<String,String>();
		se.put("qtitle", saveQtitle);
		se.put("qtitle", saveQcontext);
		FenYe.search=se;
		if(saveQtitle!=null){
			qtitle=saveQtitle;
		}
		if(saveQcontext!=null){
			qcontext=saveQcontext;
		}
		String pag=ServletActionContext.getRequest().getParameter("page");
		FenYe.fy=fs.getFenYe(FenYe.fy, pag);
		List<NewsDto> news=ns.queryByFenYe(FenYe.fy);
		request.put("qtitle", qtitle);
		request.put("qcontext", qcontext);
		session.put("news", news);
		return "newsList";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
}

package com.wzx.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.service.FenYeService;
import com.wzx.service.FileUploadService;
import com.wzx.service.NewsService;
import com.wzx.service.inter.IFenYeService;
import com.wzx.service.inter.IFileUploadService;
import com.wzx.service.inter.INewsService;

@SuppressWarnings("serial")
public class NewsAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private INewsService ns=new NewsService();
	private IFenYeService fs=new FenYeService();
	private IFileUploadService ifs=new FileUploadService();
	private NewsDto n;
	private String qtitle;
	private String qcontext;
	private String ids[];
	private List<NewsDto> news;
	private File img;//上传的图片文件
	private String imgFileName;//上传的图片的名字
	private String imgContentType;//上传的图片的类型
	public String queryNews(){
		String pag=ServletActionContext.getRequest().getParameter("page");
		FenYe.fy=fs.getFenYe(FenYe.fy, pag);
		news=ns.queryByFenYe(FenYe.fy);
		session.put("news", news);
		return "newsList";
	}
	
	public String addNews(){//添加
		if(img!=null){
			n=ifs.getNews(img, imgFileName,n);
		}
		ns.addNews(n);
		return "addNews";
	}
	
	public String toUpdate(){
		String id=ids[0];
		n=ns.queryById(id);
		return "toUpdate";
	}
	
	public String update(){//修改
		if(img!=null){
			n=ifs.getNews(img, imgFileName,n);
		}
		int i=ns.update(n);
		if(i>0){
			return "update";
		}else{
			return "error";
		}
	}
	
	public String del(){//删除
		for(String id:ids){ 
			ns.del(id);
		}
		return "del";
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public List<NewsDto> getNews() {
		return news;
	}

	public void setNews(List<NewsDto> news) {
		this.news = news;
	}

	public NewsDto getN() {
		return n;
	}

	public void setN(NewsDto n) {
		this.n = n;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getQcontext() {
		return qcontext;
	}

	public void setQcontext(String qcontext) {
		this.qcontext = qcontext;
	}
	
}

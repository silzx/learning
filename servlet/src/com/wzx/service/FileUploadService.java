package com.wzx.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;

import com.wzx.dto.NewsDto;
import com.wzx.service.inter.IFileUploadService;

public class FileUploadService implements IFileUploadService {

	@Override
	public NewsDto getNews(List<FileItem> fi) {
		NewsDto news = new NewsDto();
		try {
			for (FileItem f : fi) {
				if (f.isFormField()) {
					if ("newsid".equals(f.getFieldName())) {
						news.setNewsid(f.getString("utf-8"));
					}
					if ("title".equals(f.getFieldName())) {
						news.setTitle(f.getString("utf-8"));
					}
					if ("context".equals(f.getFieldName())) {
						news.setContext(f.getString("utf-8"));
					}
					if ("newsman".equals(f.getFieldName())) {
						news.setNewsman(f.getString("utf-8"));
					}
					if ("newsdate".equals(f.getFieldName())) {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						news.setNewsdate(sdf.parse(f.getString("utf-8")));
					}
					if ("id".equals(f.getFieldName())) {
						news.setId(f.getString("utf-8"));
					}
				} else {
					if (f.getSize() != 0) {//判断上传文件的字节大小，预防空指针错误
						String picname = f.getName();
						picname = UUID.randomUUID().toString()
								+ picname.substring(picname.lastIndexOf("."));
						File file = new File(
								"D:/apache-tomcat-7.0.81/webapps/img/"
										+ picname);
						f.write(file);
						news.setPic("../img/" + picname);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}

}

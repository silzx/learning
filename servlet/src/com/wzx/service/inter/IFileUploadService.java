package com.wzx.service.inter;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.wzx.dto.NewsDto;

public interface IFileUploadService {
	public NewsDto getNews(List<FileItem> fi);
}

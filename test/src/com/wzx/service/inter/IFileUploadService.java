package com.wzx.service.inter;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.wzx.dto.Employee;

public interface IFileUploadService {
	public Employee getEe(List<FileItem> fi);
}

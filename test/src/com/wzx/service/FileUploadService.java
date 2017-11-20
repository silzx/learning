package com.wzx.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;

import com.wzx.dto.Employee;
import com.wzx.service.inter.IFileUploadService;

public class FileUploadService implements IFileUploadService {

	@Override
	public Employee getEe(List<FileItem> fi) {
		Employee ee = new Employee();
		try {
			for (FileItem f : fi) {
				if (f.isFormField()) {
					if ("empid".equals(f.getFieldName())) {
						ee.setEmpid(Integer.parseInt(f.getString("utf-8")));;
					}
					if ("ename".equals(f.getFieldName())) {
						ee.setEname(f.getString("utf-8"));
					}
					if ("epad".equals(f.getFieldName())) {
						ee.setEpad(f.getString("utf-8"));
					}
					if ("econtext".equals(f.getFieldName())) {
						ee.setEcontext(f.getString("utf-8"));;
					}
					if ("edate".equals(f.getFieldName())) {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						ee.setEdate(sdf.parse(f.getString("utf-8")));
					}
					if ("id".equals(f.getFieldName())) {
						ee.setId(Integer.parseInt(f.getString("utf-8")));
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
						ee.setEpic("../img/" + picname);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ee;
	}

}

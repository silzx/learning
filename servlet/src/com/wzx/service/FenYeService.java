package com.wzx.service;

import com.wzx.dto.FenYe;
import com.wzx.service.inter.IFenYeService;
import com.wzx.service.inter.INewsService;

public class FenYeService implements IFenYeService{
	private INewsService ns=new NewsService();
	@Override
	public FenYe getFenYe(FenYe fy, String pag) {
		if(pag==null){
			FenYe.page=1;
		}else{
			FenYe.page=Integer.parseInt(pag);
		}
		FenYe.rowCount=ns.queryCount(FenYe.fy);
		FenYe.init();
		return fy;
	}

}

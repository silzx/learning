package com.wzx.dto;

import java.util.List;

public class Power {
	private int id;
	private int rold_id;
	private String rname;
	private List<Power> pp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRold_id() {
		return rold_id;
	}
	public void setRold_id(int rold_id) {
		this.rold_id = rold_id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public List<Power> getPp() {
		return pp;
	}
	public void setPp(List<Power> pp) {
		this.pp = pp;
	}
	
}

package com.wzx.Dto;

public class UserDto {
	private String name;
	private String pad;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPad() {
		return pad;
	}
	public void setPad(String pad) {
		this.pad = pad;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", pad=" + pad + "]";
	}
	
	
}

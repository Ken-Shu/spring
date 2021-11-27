package com.study.spring.case01;

public class Husband {
	private String name;
	private Wife wife;
	
	public Husband(String name) {
		System.out.println("建立 Husband 物件");
		this.name = name;
	}
	
	public Husband(String name, Wife wife) {
		System.out.println("建立 Husband 物件");
		this.name = name;
		this.wife = wife;
	}
	public Husband() {
		System.out.println("建立 Husband 物件");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife= wife;
	}
	@Override
	public String toString() {
		return "Husband [name=" + name + ", wife=" + wife.getName() + "]";
	}
	
}

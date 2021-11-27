package com.study.spring.case01;

public class Wife {
	private String name;
	private Husband husband;
	
	public Wife(String name) {
		System.out.println("建立 Wife 物件");
		this.name = name;
	}
	
	public Wife(String name, Husband husband) {
		System.out.println("建立 Wife 物件");
		this.name = name;
		this.husband = husband;
	}
	public Wife() {
		System.out.println("建立 Wife 物件");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	@Override
	public String toString() {
		return "Wife [name=" + name + ", husband=" + husband.getName() + "]";
	}
	
}

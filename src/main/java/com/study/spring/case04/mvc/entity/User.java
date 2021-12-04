package com.study.spring.case04.mvc.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
//不確定是 Service 或是 Repository 時使用
public class User implements Serializable{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public User() {
		super();
	}
	{
		System.out.println("User");//建構子共同實作段
	}
	
}

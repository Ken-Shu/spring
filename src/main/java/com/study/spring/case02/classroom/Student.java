package com.study.spring.case02.classroom;

import java.util.Set;
import java.util.function.ToIntFunction;

public class Student {
	private Integer id;
	private String name;
	private Set<Clazz> clazzs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Clazz> getClazzs() {
		return clazzs;
	}
	public void setClazzs(Set<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	
	public int getTotalCredits() {
		
		return getClazzs().stream().mapToInt(e ->e.getCredit()).sum();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clazzs=" + clazzs + "]";
	}	
	
}

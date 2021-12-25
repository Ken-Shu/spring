package com.study.spring.case07.jdbc;

import java.util.Date;

// Entity
public class Emp {
	private Integer eid;
	private String ename;
	private Integer age;
	private Date createdate;
	
	public Emp(String ename, Integer age) {
		super();		
		this.ename = ename;
		this.age = age;		
	}
	
	public Emp() {
		
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", age=" + age + ", createdate=" + createdate + "]";
	}
	
}

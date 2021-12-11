package com.study.spring.case06.proxy.sta;

import com.study.spring.case06.proxy.sta.*;

public class PersonProxy implements Person{
	private Person person;	
	
	public PersonProxy(Person person) {
		super();
		this.person = person;
	}

	public PersonProxy(String classname) throws Exception{
		// 要給類別全名 : 套件名 + 類別名
		String fullname = "com.study.spring.case06.proxy.sta." + classname;
		//this.person = (Person)Class.forName(fullname).newInstance();
		this.person = (Person)Class.forName(fullname) //類別全名
				.getDeclaredConstructor() //調用建構子
				.newInstance(); //建立實體
	}

	@Override
	public void work() {
		//公用方法
		System.out.println("戴口罩 (Proxy)");
		System.out.println("帶錢包 (Proxy)");
		System.out.println(person.getClass().getSimpleName());
		//執行業務方法
		person.work();
	}
	
}

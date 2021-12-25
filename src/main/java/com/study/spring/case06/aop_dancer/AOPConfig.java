package com.study.spring.case06.aop_dancer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//使用 Java 配置 替代 aop-dancer.xml

@Configuration //宣告這個 Class 是配置檔程式
//下面兩個是對應到 aop-dnacer.xml 的 component-scan 和 aspectj-autoproxy
@EnableAspectJAutoProxy
@ComponentScan
public class AOPConfig {
	
	//也可以不用寫 因為預設是 類別名稱 第一個字小寫
	@Bean(name = "dancer")
	public Performance dancer() {
	
		return new Dancer();
	}
	@Bean(name = "audience")
	//@Bean
	public Audience audience() {
	
		return new Audience();
	}
	@Bean
	public Introductor geIntroductor() {
		return new Introductor();
	}
}

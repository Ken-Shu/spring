package com.study.spring.case06.aopxml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyMaskAspect {
	public void before(JoinPoint joinpoint) {
		System.out.println("AOP XML 版 - 前置通知" );
		System.out.println("方法 : "+joinpoint.getSignature().getName()); //這個方法的名稱
		System.out.println("參數 : "+Arrays.toString(joinpoint.getArgs()));// args 這個方法所帶的參數
		System.out.println("----------------------------");
		System.out.println("戴口罩");
		System.out.println();
	}
	public void end(JoinPoint joinpoint) {
		System.out.println("AOP XML 版 - 前置通知" );
		System.out.println("方法 : "+joinpoint.getSignature().getName()); //這個方法的名稱
		System.out.println("參數 : "+Arrays.toString(joinpoint.getArgs()));// args 這個方法所帶的參數
		System.out.println("----------------------------");
		System.out.println("結束");
		System.out.println();
	}
}

package com.study.spring.case06.aopxml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
//前置通知
// JoinPoint 連接點
public class MyLoggerAspect {
	public void before(JoinPoint joinpoint) {
		System.out.println("AOP XML 版 - 前置通知" );
		System.out.println("方法 : "+joinpoint.getSignature().getName()); //這個方法的名稱
		System.out.println("參數 : "+Arrays.toString(joinpoint.getArgs()));// args 這個方法所帶的參數
	}
}

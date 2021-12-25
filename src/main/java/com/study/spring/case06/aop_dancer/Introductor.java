package com.study.spring.case06.aop_dancer;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introductor { //經紀人
	
	//將 Performance 及其子類別 轉成 Singer
	//defaultImpl 預設介面
	//歌者
	@DeclareParents(value = "com.study.spring.case06.aop_dancer.Performance+",
			defaultImpl = BackSinger.class)
	public Singer singer;
	
	//演員
	@DeclareParents(value = "com.study.spring.case06.aop_dancer.Performance+",
			defaultImpl = TalkActor.class)
	public Actor actor;
	
}

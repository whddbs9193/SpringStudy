package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;

//@Service
//@Aspect
public class AfterAdvice {
	
	@After("PointcutCommon.allPointcut()")
	public void afterLog() {
		System.out.println("[사후 처리] 비지니스 로직 수행 후 무조건 동작");
	}
}

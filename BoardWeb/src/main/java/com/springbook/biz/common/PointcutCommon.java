package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") // 이름상관없이 모든 메소드
	public void allPointcut() {} // 참조 메소드, 포인트컷 메소드
	@Pointcut("execution(* com.springbook.bix..*Impl.get*(..))") //get으로 시작하는 메소드
	public void getPointcut() {}
}

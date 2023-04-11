package com.example.demo4.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component // IOC 관리 대상이된다.
public class AopParameter {

	// 포인트 컷
	// role 설정
	// execution 표현식
	@Pointcut("execution(* com.example.demo4.controller..*.*(..))")
	private void cut() {
	}

	// cut() 메서드가 실행 되는 지점 이전에 before() 메서드를 실행
	// 관점 지향 프로그래밍
	@Before("cut()")
	public void before(JoinPoint joinPoint) {

		// controller -> /api/get 호출 하기전에 수행 되는 녀석
		// 어떤 메서드가 수행 되었는지 알아 보는 방법
		System.out.println("before 수행!");
		
		// 활용 - 어떤 메서드가 동작 되었는지 확인
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		Object[] args = joinPoint.getArgs();

		// 매개변수 출력
		for (Object obj : args) {
			System.out.println("type : " + obj.getClass().getSimpleName());
			System.out.println("value : " + obj);
		}

		/*
		 * System.out.println("사용된 method 확인");
		 * System.out.println("method : "+method.getName());
		 */
	}
	
	//cut이 실행된 후 obj 리턴 실행되는 메서드의 반환 형 따라감
	@AfterReturning(value = "cut()",returning = "obj")
	public void afterReturn(JoinPoint joinPoint, Object obj) {
		System.out.println("============");
		System.out.println("return obj");
		System.out.println("obj "+obj);
		
	}
}

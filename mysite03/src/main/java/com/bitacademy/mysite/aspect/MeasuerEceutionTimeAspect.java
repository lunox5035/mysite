package com.bitacademy.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasuerEceutionTimeAspect {
	
	@Around("execution(* *..*.repository.*.*(..)) || execution(* *..*.service.*.*(..)) || execution(* *..*.controller.*.*(..))\")")
	public Object AroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		/* before*/
		StopWatch sw =new StopWatch();
		sw.start();
	
		/* PointCut Method 실행*/
		 Object result = pjp.proceed();
		 /* before*/
		 sw.stop();
		 Long totalTime = sw.getTotalTimeMillis();
//		 System.out.println(totalTime);

			String className = pjp.getTarget().getClass().getName();
			String methodName = pjp.getSignature().getName();
			String taskName = className + "." + methodName;
			System.out.println("[Execution Time][" + taskName + "] " + totalTime + "mills");
		
		
		return result;
	}

}

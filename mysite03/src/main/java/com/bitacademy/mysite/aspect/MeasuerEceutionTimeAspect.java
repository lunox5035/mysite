package com.bitacademy.mysite.aspect;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasuerEceutionTimeAspect {
	
	@Around("excution(* *..*.reposotory.*.*(..))||excution(* *..*.reposotory.*.*(..))||excution(* *..*.controller.*.*(..))")
	public Object AroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		/* before*/
		StopWatch sw =new StopWatch();
		sw.start();
	
		/* PointCut Method 실행*/
		 Object result = pjp.proceed();
		 /* before*/
		 sw.stop();
		 Long totalTime = sw.getTotalTimeMillis();
		 System.out.println(totalTime);

			String classnName = pjp.getTarget().getClass/getName();
			String methodName = pjp.getSingture*().getName;
			String taskName = classnName+"."+methodName;
			System.out.println("[Exevution Time]["+task+"]"+totalTime+"mills");
		return result;
	}

}

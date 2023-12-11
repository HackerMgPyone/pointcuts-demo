package org.example.ascepts;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyCurrencyServiceAspect {
    @Pointcut("within(org.example.service.*)")
    public void withinPointcut(){

    }
    @Pointcut("@within(org.example.annotation.Secured)")
    public void annotationWithinPointcut(){

    }
    @Before("annotationWithinPointcut()")
    public void currencyAnnotationWithinAdvice(JoinPoint joinPoint) throws Throwable{
        System.out.println(
                String.format("%s's %s method invoked before with %s",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );

    }
//    @Before("withinPointcut()")
    public void currencyAdvice(JoinPoint joinPoint) throws Throwable{
        System.out.println(
                String.format("%s's %s method invoked before with %s",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );

    }
}

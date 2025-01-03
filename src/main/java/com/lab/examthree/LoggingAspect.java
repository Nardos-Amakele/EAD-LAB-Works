package com.lab.examthree;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* com.lab.examthree.BookRegistrationServlet.*(..))")
    public void logTBookRegistrationServlettMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] BookRegistrationServlet method called: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.lab.examthree.DisplayBooksServlet.*(..))")
    public void logDisplayBooksServletMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] DisplayBooksServlet method called: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.lab.examthree.DeleteBookServlet.*(..))")
    public void logDeleteBookServletMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] DeleteBookServlet method called: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.lab.examthree.SearchBookServlet.*(..))")
    public void logSearchBookServletMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] SearchBookServlet method called: " + joinPoint.getSignature().getName());
    }
}

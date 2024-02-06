//package com.example.monitoringNss.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//public class LoggingAdvice {
//
//    @Pointcut("within(com.example.monitoringNss.service.* ..*)")
//    private void createPoint(){};
//
//    @Around("createPoint()")
//    public Object loggin(ProceedingJoinPoint pjp){
//        log.info("---------------------------------------------------");
//        log.info("Creating some object");
//        log.info("---------------------------------------------------");
//        return pjp;
//    }
//}

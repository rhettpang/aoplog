package com.pk.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Created by pangkunkun on 2018/11/12.
 */
@Component
@Aspect
public class MethodLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodLogAspect.class);

    @Around("@annotation(com.pk.config.MethodLog)")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable{
        Signature signature = joinPoint.getSignature();
        Object[] objects = joinPoint.getArgs();
        String[] parameterNames = ((MethodSignature) signature).getParameterNames();
        int objectsLength = objects.length;
        for (int i =0;i < objectsLength; i++){
            Object o = objects[i];
            logger.info("{} = {}",parameterNames[i],o);
        }

        logger.info("Into {}");
        //接收被注解的方法返回的值，返回给调用方
        Object object = joinPoint.proceed();
        logger.info("after method");
        return object;

    }

//    // 通过反射获取参入的参数
//    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
//        String targetName = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] arguments = joinPoint.getArgs();
//        Class targetClass = Class.forName(targetName);
//        String description = "";
//
//        Method[] methods = targetClass.getMethods();
//        for (Method method : methods) {
//            if (method.getName().equals(methodName)) {
//                Class[] clazzs = method.getParameterTypes();
//
//                if (clazzs.length == arguments.length) {
////                    description = method.getAnnotation(MethodLog.class);
//                    break;
//                }
//            }
//        }
//        return description;
//    }


//    @Before("@annotation(com.pk.config.MethodLog)")
//    public void advice(final JoinPoint joinPoint) throws Throwable{
////        Signature signature = joinPoint.getSignature();
////        //获取被注解的类的方法
////        String method = signature.getDeclaringTypeName() +"."+ signature.getName();
//        System.out.println("before {}");
//        //接收被注解的方法返回的值，返回给调用方
//        System.out.println("after method");
////        return object;
//
//    }
}

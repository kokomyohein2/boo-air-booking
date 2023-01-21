package io.codeandpaan.booairbookingtx.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class AuditLoggerAspect {

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforAuditLogger(JoinPoint joinPoint) throws Exception {
        Class<?> clss = joinPoint.getTarget().getClass();
        for (Field declaredField : clss.getDeclaredFields()) {
            if (declaredField.getType().getTypeName().contains("AuditLogger")) {
                Field fieldAuditLogger = clss.getDeclaredField("auditLogger");
                fieldAuditLogger.setAccessible(true);
//                AuditLoggerImpl auditLogger = (AuditLoggerImpl) fieldAuditLogger.get(this);
//                auditLogger.beginTxn();
            }
        }

        System.out.println("join point before");
    }

//    @After("@annotation(org.springframework.transaction.annotation.Transactional)")
//    public void AfterAuditLogger(JoinPoint joinPoint) throws Exception {
//        Class<?> clss = joinPoint.getTarget().getClass();
//        for (Field declaredField : clss.getDeclaredFields()) {
//            System.out.println("fields: " + declaredField.getName());
//        }
//        Field fieldAuditLogger = clss.getDeclaredField("auditLogger");
//        fieldAuditLogger.setAccessible(true);
//        AuditLoggerImpl auditLogger = (AuditLoggerImpl) fieldAuditLogger.get(this);
//        auditLogger.commitTxn();
//        System.out.println("join point before");
//    }

//    @AfterThrowing("@annotation(org.springframework.transaction.annotation.Transactional)")
//    public void AfterThrowingAuditLogger(JoinPoint joinPoint) throws Exception {
//        Class<?> clss = joinPoint.getTarget().getClass();
//        for (Field declaredField : clss.getDeclaredFields()) {
//            System.out.println("fields: " + declaredField.getName());
//        }
//        Field fieldAuditLogger = clss.getDeclaredField("auditLogger");
//        fieldAuditLogger.setAccessible(true);
//        AuditLoggerImpl auditLogger = (AuditLoggerImpl) fieldAuditLogger.get(this);
//        auditLogger.rollBackTxn();
//    }


//    context holder
}

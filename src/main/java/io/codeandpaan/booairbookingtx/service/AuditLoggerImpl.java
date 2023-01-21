package io.codeandpaan.booairbookingtx.service;

import org.springframework.stereotype.Service;

@Service
public class AuditLoggerImpl implements IAuditLogger {

    AuditLoggerModal auditLoggerModal;

    @Override
    public void write() {
        System.out.println("super write");
    }

    @Override
    public void beginTxn() {
        System.out.println("super beginTxn");
        System.out.println("beginning txn");
        this.auditLoggerModal = new AuditLoggerModal("test", 1004);
    }

    @Override
    public void writeTxn() {
        System.out.println("super writeTxn");
        System.out.println("writting: " + auditLoggerModal.getName());

    }

    @Override
    public void commitTxn() {
        System.out.println("super commitTxn");
        System.out.println("committing : " + auditLoggerModal.getName());

    }

    @Override
    public void rollBackTxn() {
        System.out.println("super rollBackTxn");
        System.out.println("rolling back : " + auditLoggerModal.getName());

    }
}

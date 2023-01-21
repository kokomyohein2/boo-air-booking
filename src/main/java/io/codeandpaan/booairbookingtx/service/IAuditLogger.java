package io.codeandpaan.booairbookingtx.service;

import org.springframework.stereotype.Service;

public interface IAuditLogger {

    void write();
    void beginTxn();
    void writeTxn();
    void commitTxn();
    void rollBackTxn();

}

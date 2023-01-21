package io.codeandpaan.booairbookingtx.service;

public class AuditLoggerModal {
    String name;
    int id;

    public AuditLoggerModal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

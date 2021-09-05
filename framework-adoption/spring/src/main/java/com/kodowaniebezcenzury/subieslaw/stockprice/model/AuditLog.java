package com.kodowaniebezcenzury.subieslaw.stockprice.model;

public interface AuditLog {

    void record(AuditEvent monitoringTriggered);

}

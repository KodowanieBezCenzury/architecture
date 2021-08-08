package org.subieslaw.finance.demo;

public interface AuditLog {

    void record(AuditEvent monitoringTriggered);

}

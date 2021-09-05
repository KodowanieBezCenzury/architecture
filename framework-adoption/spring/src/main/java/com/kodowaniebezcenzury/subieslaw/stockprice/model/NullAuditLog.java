package com.kodowaniebezcenzury.subieslaw.stockprice.model;

public class NullAuditLog implements AuditLog{

    @Override
    public void record(AuditEvent monitoringTriggered) {
        // there is a reson this is null implementation :)        
    }
    
}

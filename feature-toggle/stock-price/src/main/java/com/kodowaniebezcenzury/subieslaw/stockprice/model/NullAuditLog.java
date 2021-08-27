package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor.AuditEvent;

public class NullAuditLog implements AuditLog{

    @Override
    public void record(AuditEvent monitoringTriggered) {
        // there is a reson this is null implementation :)        
    }
    
}

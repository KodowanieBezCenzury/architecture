package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor.AuditEvent;

public interface AuditLog {

    void record(AuditEvent monitoringTriggered);

}

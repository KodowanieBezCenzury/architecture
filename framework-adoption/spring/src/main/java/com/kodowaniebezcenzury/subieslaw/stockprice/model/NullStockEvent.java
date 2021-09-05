package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.math.BigDecimal;

public class NullStockEvent implements StockEvent{

    @Override
    public StockAlert sendBelowThresholdNotification(String ticker, BigDecimal threshold, BigDecimal price) {
        return null;
    }
    
}

package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.math.BigDecimal;

public interface StockEvent {

    StockAlert sendBelowThresholdNotification(String ticker, BigDecimal threshold, BigDecimal price);

}

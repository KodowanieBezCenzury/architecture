package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class NullStockEventTest {

    @Test
    public void should_not_blow_up(){
        assertDoesNotThrow(() -> {
            NullStockEvent nullStockEvent = new NullStockEvent();
            nullStockEvent.sendBelowThresholdNotification(null, null, null);
        });
    }
    
}

package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class NullAuditLogTest {
    
    @Test
    public void should_not_blow_up(){
        assertDoesNotThrow(()-> {
            NullAuditLog nullAuditLog = new NullAuditLog();
            nullAuditLog.record(null);
        });

    }

}

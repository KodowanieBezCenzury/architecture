package org.subieslaw.finance.demo;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class StockAlert {
    private final String ticker;
    private final BigDecimal threshold;
    private final BigDecimal price;
    private final StockAlertType alertType;    
}

enum StockAlertType {
    LOWER_THEN_EXPECTED, HIGHER_THEN_EXPECTED;
}




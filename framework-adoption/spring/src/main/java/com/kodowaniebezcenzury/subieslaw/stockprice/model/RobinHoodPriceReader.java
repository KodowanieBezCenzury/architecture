package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.math.BigDecimal;
import java.util.Optional;

public class RobinHoodPriceReader implements StockReader{

    @Override
    public Optional<StockInfo> get(String stockTicker) {
        return Optional.of(StockInfo.of(stockTicker,BigDecimal.TEN));
    }
    
}

package com.kodowaniebezcenzury.subieslaw.stockprice.model.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.Optional;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.RobinHoodPriceReader;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockInfo;

import org.junit.jupiter.api.Test;

public class RobinHoodPriceReaderItTest {
    
    @Test
    public void should_return_fixed_price_for_ticker(){
        var rhPriceReader = new RobinHoodPriceReader();
        Optional<StockInfo> optional = rhPriceReader.get("AMZN");
        StockInfo stockInfo = optional.get();
        assertEquals("AMZN", stockInfo.getTicker());
        assertEquals(BigDecimal.TEN,stockInfo.getPrice());
    }

}

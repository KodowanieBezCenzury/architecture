package com.kodowaniebezcenzury.subieslaw.stockprice.model.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockInfo;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.YahooPriceReader;

import org.junit.jupiter.api.Test;

public class YahooPriceReaderItTest {
    
    @Test
    public void should_return_same_ticker_for_requested(){
        var yPriceReader = new YahooPriceReader();
        Optional<StockInfo> optional = yPriceReader.get("AMZN");
        StockInfo stockInfo = optional.get();
        assertEquals("AMZN", stockInfo.getTicker());
        assertNotNull(stockInfo.getPrice());
    }

}

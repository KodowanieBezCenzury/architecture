package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class YahooPriceReader implements StockReader{

    @Override
    public Optional<StockInfo> get(String stockTicker) {
        try {
            Stock stock = YahooFinance.get(stockTicker);
            BigDecimal price = stock.getQuote().getPrice();
            return Optional.of(StockInfo.of(stockTicker, price));
    
        } catch (IOException e) {
            throw new RuntimeException("Unable to connect to YahooFinance.",e);
        }
    }
    
}

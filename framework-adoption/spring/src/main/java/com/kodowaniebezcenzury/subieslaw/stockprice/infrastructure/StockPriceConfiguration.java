package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.AuditLog;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.NullAuditLog;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.NullStockEvent;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.RobinHoodPriceReader;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockEvent;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockReader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockPriceConfiguration {
    
    @Bean
    public StockReader stockReader(){
        return new RobinHoodPriceReader();
    }

    @Bean
    public StockEvent stockEvent(){
        return new NullStockEvent();
    }

    @Bean
    public AuditLog auditLog(){
        return new NullAuditLog();
    }

    @Bean
    public StockPriceMonitor stockPriceMonitor(){
        return StockPriceMonitor.of(stockReader(), stockEvent(), auditLog());
    }

}

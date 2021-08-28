package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.AuditLog;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.NullAuditLog;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.NullStockEvent;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.RobinHoodPriceReader;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockEvent;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockReader;
import com.kodowaniebezcenzury.subieslaw.stockprice.model.YahooPriceReader;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StockPriceConfiguration {
    
    @Bean
    public StockReader stockReader(){
        return new RobinHoodPriceReader();
    }

    @Bean
    public StockReader yahooStockReader(){
        return new YahooPriceReader();
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
        return new StockPriceMonitor(stockReader(), stockEvent(), auditLog());
    }

    @Bean
    public StockPriceMonitor superFancystockPriceMonitor(){
        return new StockPriceMonitor(yahooStockReader(), stockEvent(), auditLog());
    }



}

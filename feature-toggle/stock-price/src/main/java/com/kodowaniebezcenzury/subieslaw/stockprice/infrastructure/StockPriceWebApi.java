package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StockPriceWebApi {

    @Qualifier("stockPriceMonitor")
    private final StockPriceMonitor priceMonitor;

    @Qualifier("superFancystockPriceMonitor")
    private final StockPriceMonitor superFancypriceMonitor;

    private final FeatureManager featureManager;

    @GetMapping(value = "/stockprice", produces = {MediaType.APPLICATION_JSON_VALUE})
    public StockResponse register(@RequestParam String ticker) {
        
        StockResponse currentStockPrice;
        if (featureManager.isActive(FeatureToggle.YAHOO_READER)) {
            currentStockPrice = new StockResponse(
                                        superFancypriceMonitor.readCurrentStockPrice(ticker).toString(),
                                         "experimental");
        } else {
            currentStockPrice = new StockResponse(
                                        priceMonitor.readCurrentStockPrice(ticker).toString(),
                                         "regular");
        }

        return currentStockPrice;
    }

}
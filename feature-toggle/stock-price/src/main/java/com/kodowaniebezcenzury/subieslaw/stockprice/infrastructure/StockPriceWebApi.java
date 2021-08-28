package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import java.math.BigDecimal;
import java.util.Optional;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/stockprice")
    public ResponseEntity<String> register(@RequestParam String ticker) {
        BigDecimal currentStockPrice;
        if (featureManager.isActive(FeatureToggle.YAHOO_READER)) {
            currentStockPrice = superFancypriceMonitor.readCurrentStockPrice(ticker);
        } else {
            currentStockPrice = priceMonitor.readCurrentStockPrice(ticker);
        }

        Optional<String> of = Optional.of(currentStockPrice.toString());
        return ResponseEntity.of(of);
    }

}
package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import java.math.BigDecimal;
import java.util.Optional;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StockPriceWebApi {

    StockPriceMonitor priceMonitor;

    @GetMapping("/stockprice")
    public ResponseEntity<String> register(@RequestParam String ticker) {
        BigDecimal currentStockPrice = priceMonitor.readCurrentStockPrice(ticker);
        Optional<String> of = Optional.of(currentStockPrice.toString());
        return ResponseEntity.of(of);
    }

}
package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StockPriceWebApi {

    private final StockPriceMonitor priceMonitor;

    @GetMapping(value = "/stockprice", produces = {MediaType.APPLICATION_JSON_VALUE})
    StockResponse readStockPrice(@RequestParam String ticker) {
        StockResponse currentStockPrice = new StockResponse();
        currentStockPrice.setStockPrice(priceMonitor.readCurrentStockPrice(ticker).toString());
        currentStockPrice.setSource("regular");
        return currentStockPrice;
    }

}
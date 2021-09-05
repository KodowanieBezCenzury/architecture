package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class StockInfo {

    private final String ticker;
    private final BigDecimal price;

}

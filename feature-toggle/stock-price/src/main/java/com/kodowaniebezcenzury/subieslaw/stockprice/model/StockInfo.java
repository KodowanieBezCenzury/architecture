package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StockInfo {

    String ticker;
    BigDecimal price;

}

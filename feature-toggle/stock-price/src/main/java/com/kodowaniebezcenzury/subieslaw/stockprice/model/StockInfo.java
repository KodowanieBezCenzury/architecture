package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
class StockInfo {

    String ticker;
    BigDecimal price;

}

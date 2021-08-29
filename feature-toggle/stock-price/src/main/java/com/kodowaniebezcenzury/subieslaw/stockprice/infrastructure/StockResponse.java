package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import lombok.*;

@AllArgsConstructor
@Data
public class StockResponse {

    private String stockPrice;
    private String source;

}

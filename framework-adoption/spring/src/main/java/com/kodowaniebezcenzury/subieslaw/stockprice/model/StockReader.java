package com.kodowaniebezcenzury.subieslaw.stockprice.model;

import java.util.Optional;

public interface StockReader {

    Optional<StockInfo> get(String stockTicker);

}

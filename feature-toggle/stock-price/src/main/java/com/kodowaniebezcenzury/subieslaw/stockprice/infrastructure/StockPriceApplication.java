package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure"})
public class StockPriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceApplication.class, args);
	}

}
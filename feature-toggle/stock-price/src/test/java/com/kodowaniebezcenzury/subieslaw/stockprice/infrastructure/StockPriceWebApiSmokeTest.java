package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StockPriceWebApiSmokeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_valid_status_for_requested_stock() throws Exception {

        mockMvc.perform(get("/stockprice").param("ticker", "AMZN"))
                .andExpect(status().isOk());
    }

}

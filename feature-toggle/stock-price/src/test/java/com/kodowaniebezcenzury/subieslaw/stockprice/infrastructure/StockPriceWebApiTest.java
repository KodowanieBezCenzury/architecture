package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure.FeatureToggle;
import com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure.StockPriceConfiguration;
import com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure.StockPriceWebApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;
import org.togglz.junit5.AllEnabled;
import org.togglz.spring.boot.actuate.autoconfigure.TogglzAutoConfiguration;

@SpringBootTest(classes = {StockPriceWebApi.class, StockPriceConfiguration.class, TogglzAutoConfiguration.class })
@AutoConfigureMockMvc
public class StockPriceWebApiTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FeatureManager featureManager;

    @Test
    public void should_return_valid_status_for_requested_stock() throws Exception{
        
        mockMvc
            .perform(get("/stockprice").param("ticker", "AMZN"))
             .andExpect(status().isOk());
    }

    @Test
    @AllEnabled(FeatureToggle.class)
    public void should_return_stock_value_for_experimental_feature() throws Exception{
        
        enableYahooFeature();

        mockMvc
            .perform(get("/stockprice").param("ticker", "AMZN"))
                .andExpect(status().isOk())
                .andExpect(content().json("10"));
    }

    @Test
    @AllEnabled(FeatureToggle.class)
    public void should_return_stock_value_for_standard_feature() throws Exception{
        
        disableYahooFeature();

        mockMvc
            .perform(get("/stockprice").param("ticker", "AMZN"))
                .andExpect(status().isOk())
                .andExpect(content().json("10"));
    }

    private void enableYahooFeature() {
        FeatureState featureState = featureManager.getFeatureState(FeatureToggle.YAHOO_READER);
        featureState.enable();
        featureManager.setFeatureState(featureState);
    }

    private void disableYahooFeature() {
        FeatureState featureState = featureManager.getFeatureState(FeatureToggle.YAHOO_READER);
        featureState.disable();
        featureManager.setFeatureState(featureState);
    }


}

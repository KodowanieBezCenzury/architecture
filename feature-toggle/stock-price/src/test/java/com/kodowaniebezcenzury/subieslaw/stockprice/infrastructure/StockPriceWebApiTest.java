package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import com.kodowaniebezcenzury.subieslaw.stockprice.model.StockPriceMonitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

@SpringBootTest
public class StockPriceWebApiTest {

    @Autowired
    private FeatureManager featureManager;

    @Autowired
    private StockPriceWebApi api;

    private MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        StockPriceMonitor regular = Mockito.mock(StockPriceMonitor.class);
        StockPriceMonitor experimental = Mockito.mock(StockPriceMonitor.class);
        
        Mockito.when(regular.readCurrentStockPrice(anyString()))
            .thenReturn(BigDecimal.valueOf(10l));
        Mockito.when(experimental.readCurrentStockPrice(anyString()))
            .thenReturn(BigDecimal.valueOf(2222l));
        
        api = new StockPriceWebApi(regular, experimental, featureManager);

        this.mockMvc = MockMvcBuilders
            .standaloneSetup(api)
            .setControllerAdvice()
            .build();

    }

    @Test
    public void should_return_stock_value_for_experimental_feature() throws Exception {

        enableYahooFeature();

        mockMvc.perform(get("/stockprice").param("ticker", "AMZN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.source", is("experimental")));
    }

    @Test
    public void should_return_stock_value_for_standard_feature() throws Exception {

        disableYahooFeature();

        mockMvc.perform(get("/stockprice").param("ticker", "AMZN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.source", is("regular")));
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

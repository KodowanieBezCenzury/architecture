package com.kodowaniebezcenzury.subieslaw.stockprice.infrastructure;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum FeatureToggle implements Feature {
    
    @Label("Experimental real stock price reader")
    YAHOO_READER

}

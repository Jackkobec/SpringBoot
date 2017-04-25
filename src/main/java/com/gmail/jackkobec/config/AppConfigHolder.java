package com.gmail.jackkobec.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Jack on 25.04.2017.
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfigHolder {

    private String privateKey;

    public AppConfigHolder() {
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}

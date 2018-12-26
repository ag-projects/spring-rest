package com.agharibi.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.agharibi.service")
public class UmServiceConfig {

    public UmServiceConfig() {
    }
}

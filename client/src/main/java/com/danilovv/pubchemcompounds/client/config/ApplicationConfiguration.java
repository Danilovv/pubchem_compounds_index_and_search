package com.danilovv.pubchemcompounds.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClients(value = {
        @RibbonClient(name = "pubchem-sdf-download-service"),
        @RibbonClient(name = "pubchem-sdf-processing-service"),
        @RibbonClient(name = "pubchem-data-indexing-service"),
        @RibbonClient(name = "pubchem-data-search-service")
}, defaultConfiguration = DefaultRibbonClientConfiguration.class)
public class ApplicationConfiguration {
    @Bean(name = "loadBalancedRestTemplate")
    @LoadBalanced
    RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
}

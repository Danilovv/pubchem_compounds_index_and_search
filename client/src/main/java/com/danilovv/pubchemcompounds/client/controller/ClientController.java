package com.danilovv.pubchemcompounds.client.controller;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final RestTemplate loadBalancedRestTemplate;
    private final DiscoveryClient discoveryClient;

    @GetMapping
    public String get() {
        return "Some info";
    }

    @GetMapping("/services/state")
    public List<String> getServicesState() {
        final List<String> results = Lists.newLinkedList();

        final List<String> services = discoveryClient.getServices();

        for (final String service : services) {
            final List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);

            for (final ServiceInstance serviceInstance : serviceInstances) {
                results.add(String.format("Service: %s. Address: %s:%s.", service, serviceInstance.getHost(), serviceInstance.getPort()));
            }
        }

        return results;
    }
}

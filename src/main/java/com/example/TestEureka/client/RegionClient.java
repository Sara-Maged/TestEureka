package com.example.TestEureka.client;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.TestEureka.model.Region;
import java.util.List;

@Service
public class RegionClient {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    public RegionClient(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    public List<Region> fetchRegions() {
        List<ServiceInstance> instances = discoveryClient.getInstances("JOBMANAGEMENTSVC");

        if (instances.isEmpty()) {
            throw new RuntimeException("No instances found for JobManagementSvc");
        }

        ServiceInstance instance = instances.get(0);
        String url = instance.getUri().toString() + "/job-api/regions";

        ResponseEntity<List<Region>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Region>>() {}
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch regions from JobManagementSvc");
        }
    }
}




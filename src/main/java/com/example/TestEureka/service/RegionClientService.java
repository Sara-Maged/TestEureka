package com.example.TestEureka.service;

import com.example.TestEureka.model.Region;
import com.example.TestEureka.client.RegionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionClientService {

    @Autowired
    private RegionClient regionClient;

    public List<Region> fetchRegions() {
        return regionClient.fetchRegions();
    }
}

package com.example.TestEureka.controller;

import com.example.TestEureka.model.Region;
import com.example.TestEureka.service.RegionClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionClientService regionClientService;

    @GetMapping("/client")
    public ResponseEntity<List<Region>> getRegionsFromJobManagement() {
        return ResponseEntity.ok(regionClientService.fetchRegions());
    }
}

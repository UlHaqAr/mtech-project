package com.mtech.project.controller;

import com.mtech.project.entity.CustomerInstallBaseModel;
import com.mtech.project.entity.RevenueModel;
import com.mtech.project.repository.CustomerInstallBaseRepository;
import com.mtech.project.repository.RevenueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/revenue")
public class RevenueController {

    private final RevenueRepository revenueRepository;

    public RevenueController(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    @GetMapping
    public List<RevenueModel> getCib(@RequestParam String org, @RequestParam String domain, @RequestParam String service) {
        List<RevenueModel> results = revenueRepository.findAll();
        List<RevenueModel> filteredResult = results.stream().filter(result -> result.getOrg().equals(org) && result.getDomain().equals(domain) && result.getService().equals(service)).collect(Collectors.toList());
        return filteredResult;
    }
}

package com.mtech.project.controller;

import com.mtech.project.entity.CustomerInstallBaseModel;
import com.mtech.project.repository.CustomerInstallBaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cib")
public class CustomerInstallBaseController {

    private final CustomerInstallBaseRepository customerInstallBaseRepository;

    public CustomerInstallBaseController(CustomerInstallBaseRepository customerInstallBaseRepository) {
        this.customerInstallBaseRepository = customerInstallBaseRepository;
    }

    @GetMapping
    public List<CustomerInstallBaseModel> getCib(@RequestParam String org, @RequestParam String domain, @RequestParam String service) {
        List<CustomerInstallBaseModel> results = customerInstallBaseRepository.findAll();
        List<CustomerInstallBaseModel> filteredResult = results.stream().filter(result -> result.getOrg().equals(org) && result.getDomain().equals(domain) && result.getService().equals(service)).collect(Collectors.toList());
        return filteredResult;
    }
}

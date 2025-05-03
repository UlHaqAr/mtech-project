package com.mtech.project.controller;

import com.mtech.project.entity.RevenueModel;
import com.mtech.project.entity.RevenueModel;
import com.mtech.project.repository.CustomerInstallBaseRepository;
import com.mtech.project.repository.RevenueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @PostMapping
    public ResponseEntity<RevenueModel> addEntry(@RequestBody RevenueModel revenueModel) {
        RevenueModel revenueModel1 = revenueRepository.save(revenueModel);
        return new ResponseEntity<>(revenueModel1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevenueModel> updateRevenue(@PathVariable Long id, @RequestBody RevenueModel revenueModel) {
        Optional<RevenueModel> optionalUser = revenueRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        RevenueModel revenueModel1 = optionalUser.get();
        revenueModel1.setName(revenueModel.getName());
        revenueModel1.setValue(revenueModel.getValue());

        RevenueModel revenueModel2 = revenueRepository.save(revenueModel1);

        return ResponseEntity.ok(revenueModel2);
    }
}

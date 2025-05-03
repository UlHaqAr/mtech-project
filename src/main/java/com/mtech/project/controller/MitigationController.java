package com.mtech.project.controller;

import com.mtech.project.entity.CustomerInstallBaseModel;
import com.mtech.project.entity.MitigationModel;
import com.mtech.project.repository.MitigationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mitigation")
public class MitigationController {

    private final MitigationRepository mitigationRepository;

    public MitigationController(MitigationRepository mitigationRepository) {
        this.mitigationRepository = mitigationRepository;
    }

    @GetMapping
    public MitigationModel getMitigation(@RequestParam String name) {
        List<MitigationModel> mitigationModels = mitigationRepository.findAll();
        Optional<MitigationModel> optional = mitigationModels.stream().filter(mitigationModel -> mitigationModel.getName().equals(name)).findFirst();
        MitigationModel emptyResult = new MitigationModel();
        return optional.isPresent()? optional.get(): emptyResult;
    }

    @PostMapping
    public ResponseEntity<MitigationModel> addEntry(@RequestBody MitigationModel mitigationModel) {
        MitigationModel mitigationModel1 = mitigationRepository.save(mitigationModel);
        return new ResponseEntity<>(mitigationModel1, HttpStatus.CREATED);
    }
}

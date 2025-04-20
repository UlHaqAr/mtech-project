package com.mtech.project.controller;

import com.mtech.project.entity.MitigationModel;
import com.mtech.project.entity.NatOverviewModel;
import com.mtech.project.repository.MitigationRepository;
import com.mtech.project.repository.NatOverviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/natoverview")
public class NatOverviewController {

    private final NatOverviewRepository natOverviewRepository;

    public NatOverviewController(NatOverviewRepository natOverviewRepository) {
        this.natOverviewRepository = natOverviewRepository;
    }

    @GetMapping
    public NatOverviewModel getMitigation(@RequestParam String name) {
        List<NatOverviewModel> natOverviewModelList = natOverviewRepository.findAll();
        Optional<NatOverviewModel> optional = natOverviewModelList.stream().filter(natOverviewModel -> natOverviewModel.getName().equals(name)).findFirst();
        NatOverviewModel emptyResult = new NatOverviewModel();
        return optional.isPresent()? optional.get(): emptyResult;
    }
}

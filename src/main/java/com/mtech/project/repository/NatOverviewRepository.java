package com.mtech.project.repository;

import com.mtech.project.entity.MitigationModel;
import com.mtech.project.entity.NatOverviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatOverviewRepository extends JpaRepository<NatOverviewModel, Long> {
}

package com.mtech.project.repository;

import com.mtech.project.entity.MitigationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MitigationRepository extends JpaRepository<MitigationModel, Long> {
}

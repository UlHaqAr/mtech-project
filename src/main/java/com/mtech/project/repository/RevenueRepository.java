package com.mtech.project.repository;

import com.mtech.project.entity.CustomerInstallBaseModel;
import com.mtech.project.entity.RevenueModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueRepository extends JpaRepository<RevenueModel, Long> {
}

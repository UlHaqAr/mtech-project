package com.mtech.project.repository;

import com.mtech.project.entity.CustomerInstallBaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInstallBaseRepository extends JpaRepository<CustomerInstallBaseModel, Long> {
}

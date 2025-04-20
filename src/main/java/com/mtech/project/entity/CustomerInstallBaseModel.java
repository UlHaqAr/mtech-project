package com.mtech.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "customer_install_base_model")
public class CustomerInstallBaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String org;
    private String domain;
    private String service;
    // country name
    private String name;
    // count value
    private int value;

    // Getters & Setters from lombok
}

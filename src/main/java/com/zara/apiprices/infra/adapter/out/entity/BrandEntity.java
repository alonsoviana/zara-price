package com.zara.apiprices.infra.adapter.out.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="BRAND")
@Data
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;
}

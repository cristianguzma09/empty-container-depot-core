package com.ecd.core.adapter.out.persistence.entity;

import com.ecd.core.domain.model.ContainerStatus;
import com.ecd.core.domain.model.Location;
import com.ecd.core.domain.model.Owner;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Container", schema ="dbo")
public class ContainerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContainerID")
    private Integer ContainerId;

    @Column(name = "ContainerNumber", length = 12, unique = true)
    private String ContainerNumber;

    @Column(name = "isoCode", length = 6, nullable = false)
    private String isoCode;

    @Column(name = "Size", nullable = false)
    private String size;


    @Column(name = "owner", nullable = false)
    private Owner owner;

    @Column(name = "")
    private ContainerStatus status;


    private Location currentLocation;


    private Integer manufactureYear;


    private Integer tareWeight;


    private Integer maxGrossWeight;


    private boolean isActive;


    private LocalDateTime createdAt;



}

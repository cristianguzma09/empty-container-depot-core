package com.ecd.core.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Container")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContainerID")
    private Long id;

    @Column(name = "ContainerNumber", nullable = false, unique = true, length = 11)
    private String containerNumber;

    @Column(name = "ISOCode", nullable = false, length = 4)
    private String isoCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OwnerID", nullable = false)
    private Owner owner;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private ContainerStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CurrentLocationID")
    private Location currentLocation;

    @Column(name = "ManufactureYear")
    private Integer manufactureYear;

    @Column(name = "TareWeight")
    private  Integer tareWeight;

    @Column(name = "MaxGrossWeight")
    private Integer maxGrossWeight;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDateTime createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ContainerStatus getStatus() {
        return status;
    }

    public void setStatus(ContainerStatus status) {
        this.status = status;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public Integer getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(Integer tareWeight) {
        this.tareWeight = tareWeight;
    }

    public Integer getMaxGrossWeight() {
        return maxGrossWeight;
    }

    public void setMaxGrossWeight(Integer maxGrossWeight) {
        this.maxGrossWeight = maxGrossWeight;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }



    /*-------------lifecycle hooks-------------*/

    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
        this.isActive = true;
        if (this.status == null)
        {
            this.status = ContainerStatus.IN_DEPOT;
        }
    }

    /*-------------Domain Helpers-------------*/

    public void changeStatus(ContainerStatus newStatus)
    {
        this.status = newStatus;
    }

    public void assignLocation(Location location)
    {
        this.currentLocation = location;
    }

    public void deactivate()
    {
        this.isActive = false;
    }




}

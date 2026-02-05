package com.ecd.core.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Container {

    private final Long id;
    private final String containerNumber;
    private final String isoCode;
    private final ContainerSize size;
    private final Owner owner;
    private ContainerStatus status;
    private Location currentLocation;
    private final Integer manufactureYear;
    private final BigDecimal tareWeight;
    private final BigDecimal maxGrossWeight;
    private boolean active;
    private final LocalDateTime createdAt;

    public Container(
            Long id,
            String containerNumber,
            String isoCode,
            ContainerSize size,
            Owner owner,
            ContainerStatus status,
            Location currentLocation,
            Integer manufactureYear,
            BigDecimal tareWeight,
            BigDecimal maxGrossWeight,
            boolean active,
            LocalDateTime createdAt
    ) {
        if (containerNumber == null || containerNumber.isBlank()) {
            throw new IllegalArgumentException("Container number is required");
        }
        if (isoCode == null || isoCode.isBlank()) {
            throw new IllegalArgumentException("ISO code is required");
        }
        if (size == null) {
            throw new IllegalArgumentException("Container size is required");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner is required");
        }
        if (tareWeight != null && tareWeight.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Tare weight cannot be negative");
        }
        if (maxGrossWeight != null && maxGrossWeight.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Max gross weight cannot be negative");
        }

        this.id = id;
        this.containerNumber = containerNumber.trim();
        this.isoCode = isoCode.trim();
        this.size = size;
        this.owner = owner;
        this.status = Objects.requireNonNullElse(status, ContainerStatus.IN_DEPOT);
        this.currentLocation = currentLocation;
        this.manufactureYear = manufactureYear;
        this.tareWeight = tareWeight;
        this.maxGrossWeight = maxGrossWeight;
        this.active = active;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    /*------------- Domain behavior -------------*/

    public void changeStatus(ContainerStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("New status cannot be null");
        }
        this.status = newStatus;
    }

    public void assignLocation(Location location) {
        this.currentLocation = location;
    }

    public void deactivate() {
        this.active = false;
    }

    /*------------- Getters -------------*/

    public Long getId() { return id; }
    public String getContainerNumber() { return containerNumber; }
    public String getIsoCode() { return isoCode; }
    public ContainerSize getSize() { return size; }
    public Owner getOwner() { return owner; }
    public ContainerStatus getStatus() { return status; }
    public Location getCurrentLocation() { return currentLocation; }
    public Integer getManufactureYear() { return manufactureYear; }
    public BigDecimal getTareWeight() { return tareWeight; }
    public BigDecimal getMaxGrossWeight() { return maxGrossWeight; }
    public boolean isActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

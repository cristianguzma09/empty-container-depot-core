package com.ecd.core.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Owner {

    private final Integer ownerId;
    private final String ownerCode;
    private final String ownerName;

    // 0..1  (ej: 0.05 = 5%)
    private final BigDecimal repairTaxRate;

    private final boolean isActive;
    private final LocalDateTime createdAt;

    public Owner(Integer ownerId,
                 String ownerCode,
                 String ownerName,
                 BigDecimal repairTaxRate,
                 boolean isActive,
                 LocalDateTime createdAt) {

        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("OwnerName es obligatorio");
        }

        BigDecimal rate = (repairTaxRate == null) ? BigDecimal.ZERO : repairTaxRate;
        if (rate.compareTo(BigDecimal.ZERO) < 0 || rate.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("RepairTaxRate debe estar entre 0 y 1");
        }

        this.ownerId = ownerId;
        this.ownerCode = (ownerCode == null || ownerCode.isBlank()) ? null : ownerCode.trim();
        this.ownerName = ownerName.trim();
        this.repairTaxRate = rate;
        this.isActive = isActive;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public Integer getOwnerId() { return ownerId; }
    public String getOwnerCode() { return ownerCode; }
    public String getOwnerName() { return ownerName; }
    public BigDecimal getRepairTaxRate() { return repairTaxRate; }
    public boolean isActive() { return isActive; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(ownerId, owner.ownerId);
    }
    @Override public int hashCode() { return Objects.hash(ownerId); }
}


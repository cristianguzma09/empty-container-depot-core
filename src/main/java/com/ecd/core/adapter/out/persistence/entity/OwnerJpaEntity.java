package com.ecd.core.adapter.out.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Owner", schema = "dbo")
public class OwnerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OwnerID")
    private Integer ownerId;

    @Column(name = "OwnerCode", length = 30, unique = true)
    private String ownerCode;

    @Column(name = "OwnerName", nullable = false, length = 120)
    private String ownerName;

    @Column(name = "RepairTaxRate", nullable = false, precision = 5, scale = 4)
    private BigDecimal repairTaxRate;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    // getters/setters
    public Integer getOwnerId() { return ownerId; }
    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }

    public String getOwnerCode() { return ownerCode; }
    public void setOwnerCode(String ownerCode) { this.ownerCode = ownerCode; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public BigDecimal getRepairTaxRate() { return repairTaxRate; }
    public void setRepairTaxRate(BigDecimal repairTaxRate) { this.repairTaxRate = repairTaxRate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean active) { isActive = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}


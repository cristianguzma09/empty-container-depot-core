package com.ecd.core.application.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OwnerResponse(
        Integer ownerId,
        String ownerCode,
        String ownerName,
        BigDecimal repairTaxRate,
        boolean isActive,
        LocalDateTime createdAt
){}
package com.ecd.core.application.dto;


import java.math.BigDecimal;

public record UpdateOwnerRequest(String ownerCode, String ownerName, BigDecimal repairTaxRate, boolean isActive) {
}
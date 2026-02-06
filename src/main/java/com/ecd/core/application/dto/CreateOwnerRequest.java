package com.ecd.core.application.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateOwnerRequest(
        @NotBlank @Size(max = 30) String ownerCode,
        @NotBlank @Size(max = 120) String ownerName,
        @NotNull @DecimalMin("0.0") @DecimalMax("1.0") BigDecimal repairTaxRate
) {}

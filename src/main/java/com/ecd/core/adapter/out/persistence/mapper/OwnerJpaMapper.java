package com.ecd.core.adapter.out.persistence.mapper;

import com.ecd.core.adapter.out.persistence.entity.OwnerJpaEntity;
import com.ecd.core.domain.model.Owner;

import java.time.LocalDateTime;

public class OwnerJpaMapper {

    public static OwnerJpaEntity toEntity(Owner domain) {
        OwnerJpaEntity e = new OwnerJpaEntity();
        e.setOwnerId(domain.getOwnerId());
        e.setOwnerCode(domain.getOwnerCode());
        e.setOwnerName(domain.getOwnerName());
        e.setRepairTaxRate(domain.getRepairTaxRate());
        e.setIsActive(domain.isActive());
        e.setCreatedAt(domain.getCreatedAt() != null
                ? domain.getCreatedAt()
                : LocalDateTime.now());
        return e;
    }

    public static Owner toDomain(OwnerJpaEntity e) {
        return new Owner(
                e.getOwnerId(),
                e.getOwnerCode(),
                e.getOwnerName(),
                e.getRepairTaxRate(),
                e.getIsActive(),
                e.getCreatedAt()
        );
    }
}


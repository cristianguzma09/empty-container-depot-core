package com.ecd.core.adapter.out.persistence.repository;

import com.ecd.core.adapter.out.persistence.entity.OwnerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerJpaRepository extends JpaRepository<OwnerJpaEntity, Integer> {

    boolean existsByOwnerNameIgnoreCase(String ownerName);

    boolean existsByOwnerCodeIgnoreCase(String ownerCode);
}



package com.ecd.core.adapter.out.persistence.repository;

import com.ecd.core.adapter.out.persistence.entity.OwnerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OwnerJpaRepository extends JpaRepository<OwnerJpaEntity, Integer> {
    @Query("""
        select case when count(o) > 0 then true else false end
        from OwnerJpaEntity o
        where upper(o.ownerName) = upper(:ownerName)
    """)
    boolean existsByOwnerNameIgnoreCase(@Param("ownerName") String ownerName);

    @Query("""
        select case when count(o) > 0 then true else false end
        from OwnerJpaEntity o
        where upper(o.ownerCode) = upper(:ownerCode)
    """)
    boolean existsByOwnerCodeIgnoreCase(@Param("ownerCode") String ownerCode);
}



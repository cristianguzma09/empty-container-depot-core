package com.ecd.core.application.port.out;


import com.ecd.core.domain.model.Owner;


import java.util.List;
import java.util.Optional;

public interface OwnerRepositoryPort {
    Owner save(Owner owner);
    Optional<Owner> findById(Integer id);
    List<Owner> findAll();
    boolean existsByNameIgnoreCase(String ownerName);
    boolean existsByCodeIgnoreCase(String ownerCode);
}
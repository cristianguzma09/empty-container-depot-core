package com.ecd.core.adapter.out.persistence;

import com.ecd.core.adapter.out.persistence.mapper.OwnerJpaMapper;
import com.ecd.core.adapter.out.persistence.repository.OwnerJpaRepository;
import com.ecd.core.application.port.out.OwnerRepositoryPort;
import com.ecd.core.domain.model.Owner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OwnerRepositoryAdapter implements OwnerRepositoryPort {

    private final OwnerJpaRepository jpaRepository;

    public OwnerRepositoryAdapter(OwnerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Owner save(Owner owner) {
        return OwnerJpaMapper.toDomain(
                jpaRepository.save(OwnerJpaMapper.toEntity(owner))
        );
    }

    @Override
    public Optional<Owner> findById(Integer id) {
        return jpaRepository.findById(id).map(OwnerJpaMapper::toDomain);
    }

    @Override
    public List<Owner> findAll() {
        return jpaRepository.findAll().stream()
                .map(OwnerJpaMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCodeIgnoreCase(String ownerCode) {
        return jpaRepository.existsByOwnerCodeIgnoreCase(ownerCode);
    }

    @Override
    public boolean existsByNameIgnoreCase(String ownerName) {
        return jpaRepository.existsByOwnerNameIgnoreCase(ownerName);
    }

}

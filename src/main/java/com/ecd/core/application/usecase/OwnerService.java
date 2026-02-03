package com.ecd.core.application.usecase;

import com.ecd.core.application.dto.CreateOwnerRequest;
import com.ecd.core.application.dto.OwnerResponse;
import com.ecd.core.application.dto.UpdateOwnerRequest;
import com.ecd.core.application.port.in.OwnerUseCase;
import com.ecd.core.application.port.out.OwnerRepositoryPort;
import com.ecd.core.domain.exception.ConflictException;
import com.ecd.core.domain.exception.NotFoundException;
import com.ecd.core.domain.model.Owner;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerService implements OwnerUseCase {

    private final OwnerRepositoryPort ownerRepo;

    public OwnerService(OwnerRepositoryPort ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    @Transactional
    public OwnerResponse create(CreateOwnerRequest req) {

        if (ownerRepo.existsByNameIgnoreCase(req.ownerName())) {
            throw new ConflictException("OwnerName ya existe");
        }
        if (ownerRepo.existsByCodeIgnoreCase(req.ownerCode())) {
            throw new ConflictException("OwnerCode ya existe");
        }

        Owner saved = ownerRepo.save(new Owner(
                null,
                req.ownerCode(),
                req.ownerName(),
                req.repairTaxRate(),
                true,
                null
        ));

        return toResponse(saved);
    }

    @Override
    public OwnerResponse getById(Integer id) {
        Owner owner = ownerRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Owner no encontrado id=" + id));
        return toResponse(owner);
    }

    @Override
    public List<OwnerResponse> list() {
        return ownerRepo.findAll().stream().map(this::toResponse).toList();
    }

    private OwnerResponse toResponse(Owner o) {
        return new OwnerResponse(
                o.getOwnerId(),
                o.getOwnerCode(),
                o.getOwnerName(),
                o.getRepairTaxRate(),
                o.isActive(),
                o.getCreatedAt()
        );
    }

    public OwnerResponse update(Integer id, UpdateOwnerRequest request){
        Owner existing = ownerRepo.findById(id).orElseThrow(() -> new NotFoundException("Owner not found id=" + id));

        Owner updated = new Owner(
            existing.getOwnerId(),
            request.ownerCode(),
            request.ownerName(),
            request.repairTaxRate(),
            request.isActive(),
            existing.getCreatedAt()
        );
        Owner saved = ownerRepo.save(updated);

        return toResponse(saved);
    }

}

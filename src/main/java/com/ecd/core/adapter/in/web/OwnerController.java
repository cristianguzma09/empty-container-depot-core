package com.ecd.core.adapter.in.web;

import com.ecd.core.application.dto.CreateOwnerRequest;
import com.ecd.core.application.dto.OwnerResponse;
import com.ecd.core.application.dto.UpdateOwnerRequest;
import com.ecd.core.application.port.in.OwnerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerUseCase ownerUseCase;

    public OwnerController(OwnerUseCase ownerUseCase) {
        this.ownerUseCase = ownerUseCase;
    }

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerResponse create(@Valid @RequestBody CreateOwnerRequest request) {
        return ownerUseCase.create(request);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public OwnerResponse getById(@PathVariable Integer id) {
        return ownerUseCase.getById(id);
    }

    // LIST
    @GetMapping
    public List<OwnerResponse> list() {
        return ownerUseCase.list();
    }


    @PutMapping("/{id}")
    public OwnerResponse update(@PathVariable Integer id, @Valid @RequestBody UpdateOwnerRequest request){
        return ownerUseCase.update(id, request);
    }
}

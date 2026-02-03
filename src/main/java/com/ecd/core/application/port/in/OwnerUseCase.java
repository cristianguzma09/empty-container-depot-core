package com.ecd.core.application.port.in;


import com.ecd.core.application.dto.CreateOwnerRequest;
import com.ecd.core.application.dto.OwnerResponse;
import com.ecd.core.application.dto.UpdateOwnerRequest;

import java.util.List;

public interface OwnerUseCase {

    OwnerResponse create(CreateOwnerRequest req);
    OwnerResponse getById(Integer id);
    OwnerResponse update(Integer id, UpdateOwnerRequest request);
    List<OwnerResponse> list();
}
package com.ecd.core.application.port.in;


import com.ecd.core.application.dto.CreateOwnerRequest;
import com.ecd.core.application.dto.OwnerResponse;

import java.util.List;

public interface OwnerUseCase {

    OwnerResponse create(CreateOwnerRequest req);
    OwnerResponse getById(Integer id);
    List<OwnerResponse> list();
}
package com.ecd.core.application.port.in;

import java.util.List;

public interface ContainerUseCase {

    ContainerResponse create(CreateContainerRequest request);

    ContainerResponse getById(Long id);

    List<ContainerResponse> list();

    ContainerResponse changesStatus(Long id, String newStatus);

    ContainerResponse moveToLocation(Long id, Long locationId);

    void deactivate(Long id);

}

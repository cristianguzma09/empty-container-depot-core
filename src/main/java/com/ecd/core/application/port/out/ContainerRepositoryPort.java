package com.ecd.core.application.port.out;

import com.ecd.core.domain.model.Container;

import java.util.List;
import java.util.Optional;

public interface ContainerRepositoryPort {

    Container save(Container container);

    Optional<Container> findById(Long id);

    List<Container> findAll();

    boolean existsByContainerNumber(String containerNumber);

}

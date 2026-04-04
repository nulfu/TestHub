package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.domain.release.*;
import com.example.testhub.infrastructure.jpa.entity.*;
import com.example.testhub.infrastructure.jpa.mapper.*;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaReleaseRepository implements ReleaseRepository {

    private final SpringDataReleaseRepository repository;
    private final ReleaseMapper mapper;

    public JpaReleaseRepository(
        SpringDataReleaseRepository repository,
        ReleaseMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Release> findById(ReleaseId id) {

        return repository.findById(id.getValue())
                .map(mapper::toDomain);
    }

    @Override
    public void save(Release release) {

        ReleaseEntity entity = mapper.toEntity(release);

        repository.save(entity);
    }
}
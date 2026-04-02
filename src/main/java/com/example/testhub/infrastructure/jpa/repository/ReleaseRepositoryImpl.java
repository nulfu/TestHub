package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.Release;
import com.example.testhub.domain.ReleaseId;
import com.example.testhub.domain.repository.ReleaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReleaseRepositoryImpl implements ReleaseRepository {

    private final ReleaseJpaRepository jpaRepository;
    private final ReleaseMapper mapper;

    public ReleaseRepositoryImpl(
        ReleaseJpaRepository jpaRepository,
        ReleaseMapper mapper
    ){
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Release find(ReleaseId id){

        return jpaRepository.findById(id.getValue())
            .map(mapper::toDomain)
            .orElseThrow();
    }

    @Override
    public void save(Release release){

        jpaRepository.save(mapper.toEntity(release));
    }
}
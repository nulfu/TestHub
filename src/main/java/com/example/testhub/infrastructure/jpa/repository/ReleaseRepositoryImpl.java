package com.example.testhub.infrastructure.jpa.repository;

import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseId;
import com.example.testhub.domain.release.ReleaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public class ReleaseRepositoryImpl implements ReleaseRepository {

    private final JpaReleaseRepository jpaRepository;
    private final ReleaseMapper mapper;

    public ReleaseRepositoryImpl(
        JpaReleaseRepository jpaRepository,
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
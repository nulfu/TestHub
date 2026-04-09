package com.example.testhub.domain.release;

import java.util.List;
import java.util.Optional;

public interface ReleaseRepository {

    Optional<Release> findById(ReleaseId id);

    List<Release> findAll();

    void save(Release release);

}
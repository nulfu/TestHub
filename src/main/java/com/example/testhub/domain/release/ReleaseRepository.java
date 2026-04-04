package com.example.testhub.domain.release;

import java.util.Optional;

public interface ReleaseRepository {

    Optional<Release> findById(ReleaseId id);

    void save(Release release);
}
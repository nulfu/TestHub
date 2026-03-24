package com.example.testhub.domain.repository;

import com.example.testhub.Release;
import com.example.testhub.ReleaseId;


public interface ReleaseRepository {

    Release find(ReleaseId id);

    void save(Release release);

}

package com.example.testhub.domain.release;

public interface ReleaseRepository {

    Release find(ReleaseId id);

    void save(Release release);

}

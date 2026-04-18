package com.example.testhub.infrastructure.config;

import com.example.testhub.domain.release.*;
import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.testcase.TestCaseVersionId;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ReleaseRepository releaseRepository;

    public DataInitializer(ReleaseRepository releaseRepository){
        this.releaseRepository = releaseRepository;
    }

    @Override
    public void run(String... args) {

        Release release = new Release(
            new ReleaseId(UUID.randomUUID()),
            new ProjectId(UUID.randomUUID()),
            "Sample Release"
        );

        for(int i = 0; i < 5; i++){
            release.addCase(
                new ReleaseCase(
                    new ReleaseCaseId(UUID.randomUUID()),
                    new TestCaseVersionId(UUID.randomUUID()),
                    null
                )
            );
        }

        releaseRepository.save(release);
    }
}
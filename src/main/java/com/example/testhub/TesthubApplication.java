package com.example.testhub;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.testhub.domain.project.ProjectId;
import com.example.testhub.domain.release.Release;
import com.example.testhub.domain.release.ReleaseRepository;
import com.example.testhub.domain.release.ReleaseId;

@SpringBootApplication
public class TesthubApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesthubApplication.class, args);
    }

    @Bean
CommandLineRunner init(
    ReleaseRepository releaseRepo
) {
    return args -> {

        Release release = new Release(
            new ReleaseId(UUID.randomUUID()),
            new ProjectId(UUID.randomUUID()),
            "リリース1"
        );

        releaseRepo.save(release);

        System.out.println("==== ReleaseID ====");
        System.out.println(release.getId().getValue());
    };
}

}

package com.example.testhub.domain.release;

import java.util.ArrayList;
import java.util.List;

public class Release {

    private final ReleaseId id;
    private final String name;

    private final List<ReleaseCase> cases = new ArrayList<>();

    public Release(
        ReleaseId id,
        String name
    ) {
        this.id = id;
        this.name = name;
    }

    public ReleaseId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ReleaseCase> getCases() {
        return cases;
    }

    public void addCase(ReleaseCase releaseCase) {
        cases.add(releaseCase);
    }

    public int getTotalCases() {
        return cases.size();
    }

    public int getCompletedCases() {

        return (int) cases.stream()
            .filter(ReleaseCase::isCompleted)
            .count();
    }

    public int getProgressPercentage() {

        if (cases.isEmpty()) {
            return 0;
        }

        return (getCompletedCases() * 100) / cases.size();
    }

}
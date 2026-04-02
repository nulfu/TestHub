package com.example.testhub.infrastructure.jpa.entity;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "release_cases")
public class ReleaseCaseEntity {

    @Id
    private UUID id;

    @Column(name = "version_id", nullable = false)
    private UUID versionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "latest_result")
    private Result latestResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_id")
    private ReleaseEntity release;

    protected ReleaseCaseEntity(){}

    public ReleaseCaseEntity(
        UUID id,
        UUID versionId,
        Result latestResult
    ){
        this.id = id;
        this.versionId = versionId;
        this.latestResult = latestResult;
    }

    public void setRelease(ReleaseEntity release){
        this.release = release;
    }

    public UUID getId(){ return id; }
    public UUID getVersionId(){ return versionId; }
    public Result getLatestResult(){ return latestResult; }
}
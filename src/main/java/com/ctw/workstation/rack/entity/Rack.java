package com.ctw.workstation.rack.entity;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "t_rack")
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID id;
    @Column(name = "serial_number", length = 20, nullable = false)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private Status status;
    @Column(name="team_id")
    private UUID teamId;
    @Column(name="assembled_at")
    private Timestamp assembledAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_at")
    private Timestamp modifiedAt;
    @Column(name="default_location")
    private String defaultLocation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false, insertable = false, nullable = false)
    private Team team;
    @OneToMany(mappedBy = "rackId", fetch = FetchType.LAZY)
    private List<com.ctw.workstation.rackasset.entity.RackAsset> rackAssets;
    @OneToMany(mappedBy = "rackId", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    private Rack(UUID id, String serialNumber, Status status, UUID teamId, String defaultLocation, Timestamp assembledAt, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;
        this.teamId = teamId;
        this.defaultLocation = defaultLocation;
        this.assembledAt = assembledAt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Rack() {

    }

    public UUID getId() {
        return id;
    }

    public Timestamp getAssembledAt() {
        return assembledAt;
    }

    public void setAssembledAt(Timestamp assembledAt) {
        this.assembledAt = assembledAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }
}

package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "t_booking")
public class Booking{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_from", nullable = false)
    private Timestamp bookFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_to", nullable = false)
    private Timestamp bookTo;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "rack_id", nullable = false)
    private UUID rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    @Column(name = "requester_id", nullable = false)
    private UUID requesterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", updatable = false, insertable = false, nullable = false)
    private TeamMember teamMember;

    public Booking(){}

    public Booking(UUID id, Timestamp bookFrom, Timestamp bookTo, UUID rackId, UUID requesterId, Timestamp createdAt, Timestamp modifiedAt){
        this.id = id;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.rackId = rackId;
        this.requesterId = requesterId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getBookTo() {
        return bookTo;
    }

    public void setBookTo(Timestamp bookTo) {
        this.bookTo = bookTo;
    }

    public Timestamp getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(Timestamp bookFrom) {
        this.bookFrom = bookFrom;
    }

    public UUID getId() {
        return id;
    }
}

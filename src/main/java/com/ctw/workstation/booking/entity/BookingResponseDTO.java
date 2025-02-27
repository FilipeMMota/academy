package com.ctw.workstation.booking.entity;

import java.sql.Timestamp;
import java.util.UUID;

public record BookingResponseDTO(UUID id, Timestamp bookFrom, Timestamp bookTo, UUID rackId, Timestamp createdAt, Timestamp modifiedAt) {
    public BookingResponseDTO(Booking booking){
        this(booking.getId(), booking.getBookFrom(), booking.getBookTo(), booking.getRackId(), booking.getCreatedAt(), booking.getModifiedAt());
    }
}

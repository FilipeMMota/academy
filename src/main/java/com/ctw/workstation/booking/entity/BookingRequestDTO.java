package com.ctw.workstation.booking.entity;

import java.sql.Timestamp;
import java.util.UUID;

public record BookingRequestDTO(Timestamp bookFrom, Timestamp bookTo, UUID rackId, UUID requesterId) {}

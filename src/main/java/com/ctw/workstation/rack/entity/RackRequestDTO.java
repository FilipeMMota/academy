package com.ctw.workstation.rack.entity;

import java.sql.Timestamp;
import java.util.UUID;

public record RackRequestDTO(String serialNumber, Status status, UUID teamId, String defaultLocation, Timestamp assembledAt) {
}

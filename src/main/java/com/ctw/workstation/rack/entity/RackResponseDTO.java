package com.ctw.workstation.rack.entity;

import com.ctw.workstation.rackasset.entity.RackAsset;

import java.sql.Timestamp;
import java.util.UUID;

public record RackResponseDTO(UUID id, String serialNumber, Status status, UUID teamId, String defaultLocation, Timestamp assembledAt, Timestamp createdAt, Timestamp modifiedAt) {
    public RackResponseDTO(Rack rack){
        this(rack.getId(), rack.getSerialNumber(), rack.getStatus(), rack.getTeamId(), rack.getDefaultLocation(), rack.getAssembledAt(), rack.getCreatedAt(), rack.getModifiedAt());
    }
}

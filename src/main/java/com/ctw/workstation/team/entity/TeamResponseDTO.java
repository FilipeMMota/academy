package com.ctw.workstation.team.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public record TeamResponseDTO(UUID id, String name, String product, String defaultLocation, Timestamp createdAt, Timestamp modifiedAt) {

    public TeamResponseDTO( Team team) {
        this(team.getId(), team.getName(), team.getProduct(), team.getDefaultLocation(), team.getCreatedAt(), team.getModifiedAt());
    }
}

package com.ctw.workstation.teammember.entity;

import java.sql.Timestamp;
import java.util.UUID;

public record TeamMemberResponseDTO(UUID id, UUID teamId, String ctwId, String name, Timestamp createdAt, Timestamp modifiedAt) {
    public TeamMemberResponseDTO(TeamMember teamMember) {
        this(teamMember.getId(), teamMember.getTeamId(), teamMember.getCtwId(), teamMember.getName(), teamMember.getCreatedAt(), teamMember.getModifiedAt());
    }
}

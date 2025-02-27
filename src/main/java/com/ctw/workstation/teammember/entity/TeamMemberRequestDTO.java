package com.ctw.workstation.teammember.entity;

import java.util.UUID;

public record TeamMemberRequestDTO(String name, String ctwId, UUID teamId) {}

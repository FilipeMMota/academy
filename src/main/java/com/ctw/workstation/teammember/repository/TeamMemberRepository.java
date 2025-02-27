package com.ctw.workstation.teammember.repository;

import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepository<TeamMember> {
    public TeamMember findById(UUID teamMemberId) {
        return find("id", teamMemberId).firstResult();
    }

    public void deleteById(UUID teamMemberId) {
        TeamMember teamMemberFound = findById(teamMemberId);
        delete(teamMemberFound);
    }
}

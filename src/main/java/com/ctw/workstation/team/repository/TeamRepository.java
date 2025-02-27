package com.ctw.workstation.team.repository;

import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class TeamRepository implements PanacheRepository<Team> {
    public Team findById(UUID teamId) {
        return find("id", teamId).firstResult();
    }

    public void deleteById(UUID teamId) {
        Team team = findById(teamId);
        delete(team);
    }
}

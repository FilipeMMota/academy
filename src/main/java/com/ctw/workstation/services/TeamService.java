package com.ctw.workstation.services;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import com.ctw.workstation.team.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamService {
    @Inject
    TeamRepository teamRepository;

    public List<TeamResponseDTO> getAllTeams(){
        List<Team> newTeams = teamRepository.listAll();
        return newTeams.stream().map(TeamResponseDTO::new).collect(Collectors.toList());
    }

    public Team getTeamById(UUID id){
        return this.teamRepository.findById(id);
    }

    public TeamResponseDTO getTeamResponseDTOById(UUID id){
        return new TeamResponseDTO(this.getTeamById(id));
    }

    @Transactional
    public TeamResponseDTO addTeam(TeamRequestDTO teamFromRequestBody){
        Team newTeam = new Team();

        newTeam.setName(teamFromRequestBody.name());
        newTeam.setProduct(teamFromRequestBody.product());
        newTeam.setDefaultLocation(teamFromRequestBody.defaultLocation());

        teamRepository.persistAndFlush(newTeam);

        return new TeamResponseDTO(newTeam);
    }

    @Transactional
    public TeamResponseDTO updateTeam(Team existingTeam, TeamRequestDTO givenTeam) {
        existingTeam.setName(givenTeam.name());
        existingTeam.setProduct(givenTeam.product());
        existingTeam.setDefaultLocation(givenTeam.defaultLocation());

        teamRepository.getEntityManager().merge(existingTeam);

        return new TeamResponseDTO(existingTeam) ;
    }

    @Transactional
    public void deleteTeam(UUID teamId){
        teamRepository.deleteById(teamId);
    }
}

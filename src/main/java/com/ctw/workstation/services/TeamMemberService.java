package com.ctw.workstation.services;

import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberRequestDTO;
import com.ctw.workstation.teammember.entity.TeamMemberResponseDTO;
import com.ctw.workstation.teammember.repository.TeamMemberRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService {
    @Inject
    TeamMemberRepository teamMemberRepository;

    public List<TeamMemberResponseDTO> getAllTeamMembers(){
        List<TeamMember> teamMembers = this.teamMemberRepository.listAll();
        return teamMembers.stream().map(TeamMemberResponseDTO::new).toList();
    }

    public TeamMember getTeamMemberById(UUID id){
        return this.teamMemberRepository.findById(id);
    }

    public TeamMemberResponseDTO getTeamMemberResponseById(UUID id){
        return new TeamMemberResponseDTO(this.teamMemberRepository.findById(id));
    }


    @Transactional
    public TeamMemberResponseDTO addTeamMember(TeamMemberRequestDTO teamMemberFromRequestBody){
        TeamMember newTeamMember = new TeamMember();
        newTeamMember.setName(teamMemberFromRequestBody.name());
        newTeamMember.setTeamId(teamMemberFromRequestBody.teamId());
        newTeamMember.setCtwId(teamMemberFromRequestBody.ctwId());

        this.teamMemberRepository.persistAndFlush(newTeamMember);

        return new TeamMemberResponseDTO(newTeamMember);
    }

    @Transactional
    public TeamMemberResponseDTO updateTeamMember(TeamMember existingTeamMember, TeamMemberRequestDTO givenTeamMember) {
        existingTeamMember.setName(givenTeamMember.name());
        existingTeamMember.setCtwId(givenTeamMember.ctwId());
        existingTeamMember.setTeamId(givenTeamMember.teamId());

        this.teamMemberRepository.getEntityManager().merge(existingTeamMember);

        return new TeamMemberResponseDTO(existingTeamMember);
    }

    @Transactional
    public void deleteTeamMember(UUID teamMemberId){
        this.teamMemberRepository.deleteById(teamMemberId);
    }
}

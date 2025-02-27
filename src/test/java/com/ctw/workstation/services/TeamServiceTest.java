package com.ctw.workstation.services;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import com.ctw.workstation.team.repository.TeamRepository;
import config.CtwAcademyTestProfile;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@QuarkusTest
@TestProfile(CtwAcademyTestProfile.class) // Profile pode ter varios resources la dentro
//@QuarkusTestResource(CtwAcademyResource.class) // So pode ser um por resouse
class TeamServiceTest {


    @Inject
    TeamService teamService;

    @Inject
    TeamRepository teamRepository;


//    @Test
//    @DisplayName("Create team")
//    public void create_team(){
//        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("Planters", "Plant", "Lisbon");
//
//        TeamResponseDTO teamResponseDTO = teamService.addTeam(teamRequestDTO);
//
//        assertThat(teamResponseDTO).hasNoNullFieldsOrPropertiesExcept("racks", "teamMembers").usingRecursiveComparison().ignoringFields("id", "createdAt", "modifiedAt", "racks", "teamMembers").isEqualTo(teamRequestDTO);
//
//        assertThat(teamRepository.findById(teamResponseDTO.id())).isNotNull();
//    }
//
//    @Test
//    @DisplayName("Create team with mocks")
//    void create_team_mock(){
//
//        Mockito.doThrow(new IllegalArgumentException("Erro")).when(teamRepository).persistAndFlush(Mockito.any(Team.class));
////        Mockito.when(teamRepository.persist(Mockito.any(Team.class)));
//
//        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("Planters", "Plant", "Lisbon");
//
//        TeamResponseDTO teamResponseDTO = teamService.addTeam(teamRequestDTO);
//
//        assertThat(teamResponseDTO).hasNoNullFieldsOrPropertiesExcept("racks", "teamMembers").usingRecursiveComparison().ignoringFields("id", "createdAt", "modifiedAt", "racks", "teamMembers").isEqualTo(teamRequestDTO);
//
////        assertThat(teamRepository.findById(teamResponseDTO.id())).isNotNull();
//    }
//
//    @Test
//    @DisplayName("Create team with mocks")
//    void create_team_mock_endpoint(){
//
//        // faz o mesmo que o @InjectMock
////        TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
////        QuarkusMock.installMockForType(teamRepository, TeamRepository.class);
//
//        Mockito.doThrow(new IllegalArgumentException("Erro")).when(teamRepository).persist(Mockito.any(Team.class));
////        Mockito.when(teamRepository.persist(Mockito.any(Team.class)));
//
//        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("Planters", "Plant", "Lisbon");
//
//        TeamResponseDTO teamResponseDTO = teamService.addTeam(teamRequestDTO);
//
//        assertThat(teamResponseDTO).hasNoNullFieldsOrPropertiesExcept("racks", "teamMembers").usingRecursiveComparison().ignoringFields("id", "createdAt", "modifiedAt", "racks", "teamMembers").isEqualTo(teamRequestDTO);
//
////        assertThatThrownBy(() -> teamService.create(teamDTO))
//
////        assertThat(teamRepository.findById(teamResponseDTO.id())).isNotNull();
//    }
//
//    @Test
//    @DisplayName("Create team with mocks")
//    void create_team_mock_database(){
//
//        TeamRepository teamRepositoryMock = Mockito.mock(TeamRepository.class);
//        QuarkusMock.installMockForInstance(teamRepositoryMock, teamRepository);
//
//        TeamRequestDTO teamDTO = new TeamRequestDTO("Planters", "Plant", "Lisbon");
//
//        TeamResponseDTO teamResponseDTO = teamService.addTeam(teamDTO);
//
//        assertThat(teamResponseDTO)
//                .as("DTO from persisted team was returned with no null fields")
//                .hasNoNullFieldsOrPropertiesExcept("racks", "teamMembers")
//                .usingRecursiveComparison()
//                .ignoringFields("id", "createdAt", "modifiedAt", "racks", "teamMembers")
//                .as("DTO was returned wit data persisted")
//                .isEqualTo(teamDTO);
//
//        assertThat(teamRepository.findById(teamResponseDTO.id())).isNotNull();
//    }
}
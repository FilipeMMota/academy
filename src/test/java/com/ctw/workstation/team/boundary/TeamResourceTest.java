package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;


@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Makes possible to maintain state
@TestHTTPEndpoint(TeamResource.class) // configure base endpoint for all tests below
class TeamResourceTest {

    UUID teamId;

    static List<TeamRequestDTO> listOfTeams = List.of(new TeamRequestDTO("Planters", "Plant", "Lisbon"),
    new TeamRequestDTO("Flyers", "Fly", "Porto"));

    @BeforeAll
    public static void setup(){

    }

    @Test
    @DisplayName("Fetching all teams")
    @Order(2)
    void get_all_teams() {
        List<TeamResponseDTO> listOfTeams = get().as(new TypeRef<List<TeamResponseDTO>>() {});

        assertThat(listOfTeams).hasSize(1);
        assertThat(listOfTeams).allSatisfy((teamDto) -> assertThat(teamDto).hasNoNullFieldsOrPropertiesExcept( "teamMembers"));

//        List<TeamResponseDTO> teamDto = given()
//                .header("Content-Type", "application/json")
//        .when()
//                .get()
//        .then()
//                .statusCode(SC_OK).
//                assertThat()
//                .body("$.size()", is(1)).extract().as(List<TeamResponseDTO.class>);
    }

    @Test
    @DisplayName("Creating team")
    @Order(1)
    void create_team(){

        TeamRequestDTO teamToCreate = listOfTeams.getFirst();

        TeamResponseDTO teamDto = given()
                .contentType(ContentType.JSON)
                .body(teamToCreate)
        .when()
                .post()
        .then()
                .assertThat()
                .statusCode(SC_CREATED)
                .body("id", is(notNullValue(UUID.class)))
                .body("name", equalTo("Planters")).and()
                .body("product", equalTo("Plant")).and()
                .body("defaultLocation", equalTo("Lisbon")).extract().as(TeamResponseDTO.class);

        assertThat(teamDto).as("Team without null values").hasNoNullFieldsOrPropertiesExcept("racks", "teamMembers");
        // .usingRecursiveAssertion().ignoringFields("id", "createdAt", "modifiedAt", "racks", "teamMembers").isEqualTo(teamToCreate);
    }
}
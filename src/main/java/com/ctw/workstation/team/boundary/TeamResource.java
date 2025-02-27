package com.ctw.workstation.team.boundary;

import com.ctw.workstation.services.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamRequestDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.slf4j.MDC;

import java.util.List;
import java.util.UUID;

@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamService teamService;

    @GET
    public Response getAllTeams(){
        List<TeamResponseDTO> teams = teamService.getAllTeams();
        Log.info("GotAllTeams");
        return Response.status(200).entity(teams).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamById(@PathParam("id") UUID id){
        TeamResponseDTO teamFound = this.teamService.getTeamResponseDTOById(id);
        Log.info("FoundTeamWithId");
        return Response.status(200).entity(teamFound).build();
    }


    @POST
    public Response createNewTeam(@RequestBody TeamRequestDTO team) {
        TeamResponseDTO newTeam = this.teamService.addTeam(team);
        MDC.put("request.id", UUID.randomUUID().toString());
        MDC.put("request.path", "com/ctw/workstation/team/boundary/TeamResource.java");
        Log.infov("Team created with id: {0}", newTeam.id());
        return Response.status(201).entity(newTeam).build();
    }

    @PUT
    @Path("{id}")
    public Response updateTeamWithId(@PathParam("id") UUID teamId, @RequestBody TeamRequestDTO team) {
        Team teamFound = this.teamService.getTeamById(teamId);
        if(teamFound == null){
            Log.info("TeamNotFound");
            return Response.status(404).tag("Team Not Found").build();
        }
        TeamResponseDTO newTeam = this.teamService.updateTeam(teamFound, team);
        Log.info("TeamUpdated");
        return Response.status(200).entity(newTeam).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTeamWithId(@PathParam("id") UUID teamId) {
        this.teamService.deleteTeam(teamId);
        Log.info("TeamDeletedWithSucess");
        return Response.status(204).build();
    }
}

package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.services.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberRequestDTO;
import com.ctw.workstation.teammember.entity.TeamMemberResponseDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

@Path("/teamMember")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamMemberResource {

    @Inject
    TeamMemberService teamMemberService;

    @GET
    public Response getAllTeamMembers(){
        List<TeamMemberResponseDTO> teams = teamMemberService.getAllTeamMembers();
        return Response.status(200).entity(teams).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamMemberById(@PathParam("id") UUID id){
        TeamMemberResponseDTO teamFound = this.teamMemberService.getTeamMemberResponseById(id);
        return Response.status(200).entity(teamFound).build();
    }


    @POST
    public Response createNewTeamMember(@RequestBody TeamMemberRequestDTO teamMember) {
        TeamMemberResponseDTO newTeam = this.teamMemberService.addTeamMember(teamMember);
        return Response.status(201).entity(newTeam).build();
    }

    @PUT
    @Path("{id}")
    public Response updateTeamMemberWithId(@PathParam("id") UUID teamMemberId, @RequestBody TeamMemberRequestDTO teamMember) {
        TeamMember teamMemberFound = this.teamMemberService.getTeamMemberById(teamMemberId);
        if(teamMemberFound == null){
            return Response.status(404).tag("Team Member Not Found").build();
        }
        TeamMemberResponseDTO newTeam = this.teamMemberService.updateTeamMember(teamMemberFound, teamMember);
        return Response.status(200).entity(newTeam).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTeamMemberWithId(@PathParam("id") UUID teamMemberId) {
        this.teamMemberService.deleteTeamMember(teamMemberId);
        return Response.status(204).build();
    }
}

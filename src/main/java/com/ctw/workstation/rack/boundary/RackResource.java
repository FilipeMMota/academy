package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRequestDTO;
import com.ctw.workstation.rack.entity.RackResponseDTO;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.services.RackService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Path("/racks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RackResource {

    @Inject
    RackService rackService;

    @GET
    public Response getAllRacks() {
        List<RackResponseDTO> listOfRacks = this.rackService.getAllRacks();
       return Response.ok(listOfRacks).build();
    }

    @GET
    @Path("{id}")
    public Response getRackById(@PathParam("id") UUID rackId) {
        RackResponseDTO rackFound = this.rackService.getRackResponse(rackId);
        return Response.ok(rackFound).build();
    }

//    @GET
//    @Path("racks")
//    public Response getRacksAccordingToStatus(@QueryParam("status") Status status) {
//        List<Rack> listOfRacks = this.rackService.getAllRacksAccordingToStatus(status);
//        Map<String, List<Rack>> mapOfRacks = new HashMap<>();
//        mapOfRacks.put("vehicles", listOfRacks);
//        return Response.ok(mapOfRacks).build();
//    }

    @POST
    public Response createNewRack(@RequestBody RackRequestDTO rack) {
        RackResponseDTO newRack = this.rackService.addRack(rack);
        return Response.status(201).entity(newRack).build();
    }

    @PUT
    @Path("{id}")
    public Response updateRackWithId(@PathParam("id") UUID rackId, @RequestBody RackRequestDTO rack) {
        Rack rackFound = this.rackService.getRack(rackId);
        if(rackFound == null){
            return Response.status(404).build();
        }
        RackResponseDTO newRack = this.rackService.updateRack(rackFound, rack);
        return Response.status(200).entity(newRack).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteRackWithId(@PathParam("id") UUID rackId) {
        this.rackService.deleteRack(rackId);
        return Response.status(204).build();
    }
}

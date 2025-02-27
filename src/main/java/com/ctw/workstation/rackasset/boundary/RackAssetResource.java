package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetRequestDTO;
import com.ctw.workstation.rackasset.entity.RackAssetResponseDTO;
import com.ctw.workstation.services.RackAssetService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

@Path("/rackAssets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RackAssetResource {

    @Inject
    RackAssetService rackAssetService;

    @GET
    public Response getAllRackAssets() {
        List<RackAssetResponseDTO> listOfRacks = this.rackAssetService.getAllRackAssets();
        return Response.ok(listOfRacks).build();
    }

    @GET
    @Path("{id}")
    public Response getRackAssetById(@PathParam("id") UUID rackAssetId) {
        RackAssetResponseDTO rackFound = this.rackAssetService.getRackAssetResponseDTOById(rackAssetId);
        return Response.ok(rackFound).build();
    }

    @POST
    public Response createNewRackAsset(@RequestBody RackAssetRequestDTO rackAsset) {
        RackAssetResponseDTO newRack = this.rackAssetService.addRackAsset(rackAsset);
        return Response.status(201).entity(newRack).build();
    }

    @PUT
    @Path("{id}")
    public Response updateRackAssetWithId(@PathParam("id") UUID rackId, @RequestBody RackAssetRequestDTO rackAsset) {
        RackAsset rackAssetFound = this.rackAssetService.getRackAssetById(rackId);
        if(rackAssetFound == null){
            return Response.status(404).build();
        }
        RackAssetResponseDTO newRack = this.rackAssetService.updateRackAsset(rackAssetFound, rackAsset);
        return Response.status(200).entity(newRack).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteRackWithId(@PathParam("id") UUID rackAssetId) {
        this.rackAssetService.deleteRackAsset(rackAssetId);
        return Response.status(204).build();
    }
}

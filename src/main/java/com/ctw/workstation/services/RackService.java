package com.ctw.workstation.services;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRequestDTO;
import com.ctw.workstation.rack.entity.RackResponseDTO;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.rack.repository.RackRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;

    public List<RackResponseDTO> getAllRacks(){
        List<Rack> racks = rackRepository.listAll();
        return racks.stream().map(RackResponseDTO::new).collect(Collectors.toList());
    }

//    public List<RackResponseDTO> getAllRacksAccordingToStatus(Status status) {
//        List<Rack> racks = rackRepository.listAll();
//       return racks.stream().filter(rack -> rack.getStatus().equals(status)).toList();
//    }

    public Rack getRack(UUID id){
        return rackRepository.findById(id);
    }

    public RackResponseDTO getRackResponse(UUID id){
        return new RackResponseDTO(rackRepository.findById(id));
    }

    @Transactional
    public RackResponseDTO addRack(RackRequestDTO rackFromRequestBody){
        Rack newRack = new Rack();
        newRack.setSerialNumber(rackFromRequestBody.serialNumber());
        newRack.setStatus(rackFromRequestBody.status());
        newRack.setTeamId(rackFromRequestBody.teamId());
        newRack.setAssembledAt(rackFromRequestBody.assembledAt());
        newRack.setDefaultLocation(rackFromRequestBody.defaultLocation());

        rackRepository.persistAndFlush(newRack);

        return new RackResponseDTO(newRack);
    }

    @Transactional
    public RackResponseDTO updateRack(Rack existingRack, RackRequestDTO givenRack) {
        existingRack.setSerialNumber(givenRack.serialNumber());
        existingRack.setStatus(givenRack.status());
        existingRack.setTeamId(givenRack.teamId());
        existingRack.setDefaultLocation(givenRack.defaultLocation());
        existingRack.setAssembledAt(givenRack.assembledAt());

        rackRepository.getEntityManager().merge(existingRack);

        return new RackResponseDTO(existingRack);
    }

    @Transactional
    public void deleteRack(UUID rackId){
        rackRepository.deleteById(rackId);
    }
}

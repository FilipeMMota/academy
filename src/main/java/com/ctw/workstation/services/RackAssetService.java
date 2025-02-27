package com.ctw.workstation.services;

import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetRequestDTO;
import com.ctw.workstation.rackasset.entity.RackAssetResponseDTO;
import com.ctw.workstation.rackasset.repository.RackAssetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackAssetService {
    @Inject
    RackAssetRepository rackAssetRepository;

    public List<RackAssetResponseDTO> getAllRackAssets(){
        List<RackAsset> rackAssets = rackAssetRepository.listAll();
        return rackAssets.stream().map(RackAssetResponseDTO::new).collect(Collectors.toList());
    }

    public RackAssetResponseDTO getRackAssetResponseDTOById(UUID id){
        return new RackAssetResponseDTO(rackAssetRepository.findById(id));
    }

    public RackAsset getRackAssetById(UUID id){
        return rackAssetRepository.findById(id);
    }

    @Transactional
    public RackAssetResponseDTO addRackAsset(RackAssetRequestDTO rackAssetFromRequestBody){
        RackAsset newRack = new RackAsset();
        newRack.setAssetTag(rackAssetFromRequestBody.assetTag());
        newRack.setRackId(rackAssetFromRequestBody.rackId());

        rackAssetRepository.persistAndFlush(newRack);

        return new RackAssetResponseDTO(newRack);
    }

    @Transactional
    public RackAssetResponseDTO updateRackAsset(RackAsset existingRackAsset, RackAssetRequestDTO givenRackAsset) {
        existingRackAsset.setAssetTag(givenRackAsset.assetTag());
        existingRackAsset.setRackId(givenRackAsset.rackId());

        rackAssetRepository.getEntityManager().merge(existingRackAsset);

        return new RackAssetResponseDTO(existingRackAsset);
    }

    @Transactional
    public void deleteRackAsset(UUID rackAssetId){
        rackAssetRepository.deleteById(rackAssetId);
    }
}

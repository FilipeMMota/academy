package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;

import java.util.UUID;

public record RackAssetResponseDTO (UUID id, String assetTag, UUID rackId){
    public RackAssetResponseDTO(RackAsset rackAsset){
        this(rackAsset.getId(), rackAsset.getAssetTag(), rackAsset.getRackId());
    }
}

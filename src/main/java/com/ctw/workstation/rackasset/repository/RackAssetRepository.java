package com.ctw.workstation.rackasset.repository;

import com.ctw.workstation.rackasset.entity.RackAsset;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class RackAssetRepository implements PanacheRepository<RackAsset> {
    public RackAsset findById(UUID rackAssetId) {
        return find("id", rackAssetId).firstResult();
    }

    public void deleteById(UUID rackAssetId) {
       RackAsset rackAsset = findById(rackAssetId);
       delete(rackAsset);
    }
}

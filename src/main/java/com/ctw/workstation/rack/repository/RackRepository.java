package com.ctw.workstation.rack.repository;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class RackRepository implements PanacheRepository<Rack> {
    public Rack findById(UUID rackId) {
        return find("id", rackId).firstResult();
    }

    public void deleteById(UUID rackId) {
        Rack rack = findById(rackId);
        delete(rack);
    }
}

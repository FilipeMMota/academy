package com.ctw.workstation.databases;

import com.ctw.workstation.generalentities.Identifier;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public abstract class Database<T extends Identifier> {
    private final Map<String, T> entity;

    public Database() {
        this.entity = new HashMap<>();
    }

    public void addEntity(T newEntity) {
        entity.put(newEntity.getId(), newEntity);
    }

    public void deleteEntity(String id) {
        entity.remove(id);
    }

    public T getEntity(String id) {
        return entity.get(id);
    }

    public Map<String, T> getAllEntities() {
        return entity;
    }
}

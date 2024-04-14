package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;

public class InMemoryMetalRepository implements MetalRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryMetalRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Metal add(String name, long credits) throws MetalAlreadyExistException {
        return inMemoryDatabase.InsertIntoMetalTable(name,credits);
    }
}

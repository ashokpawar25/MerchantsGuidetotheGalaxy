package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import jakarta.inject.Inject;

public class IntergalacticUnitService {
    IntergalacticUnitRepository intergalacticUnitRepository;
    @Inject
    public IntergalacticUnitService(IntergalacticUnitRepository intergalacticUnitRepository) {
        this.intergalacticUnitRepository = intergalacticUnitRepository;
    }

    public IntergalacticUnit create(String intergalacticValue, String romanValue, double actualValue) throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException {
        return intergalacticUnitRepository.add(intergalacticValue,romanValue,actualValue);
    }

    public IntergalacticUnit get(String intergalacticValue) {
        return intergalacticUnitRepository.find(intergalacticValue);
    }
}

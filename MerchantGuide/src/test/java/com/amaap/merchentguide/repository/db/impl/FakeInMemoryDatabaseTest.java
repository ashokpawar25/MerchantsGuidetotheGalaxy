package com.amaap.merchentguide.repository.db.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {
    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();
    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticTransactionUnit actual = fakeInMemoryDatabase.InsertIntoIntergalacticTransactionUnitTable(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        fakeInMemoryDatabase.InsertIntoIntergalacticTransactionUnitTable(intergalacticValue,romanValue,actualValue);
        IntergalacticTransactionUnit actual = fakeInMemoryDatabase.selectFromIntergalacticTransactionUnitTable(intergalacticValue);

        // assert
        assertEquals(expected,actual);
    }


    @Test
    void shouldBeAbleToAddMetalIntoMetalTable() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name,credits);

        // act
        Metal actual = fakeInMemoryDatabase.InsertIntoMetalTable(name,credits);

        // assert
        assertEquals(expected,actual);

    }

    @Test
    void shouldBeAbleToThrowExceptionWhenMetalIsAlreadyPresentInDatabase() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        fakeInMemoryDatabase.InsertIntoMetalTable("Silver",17);

        // assert
        assertThrows(MetalAlreadyExistException.class,()-> fakeInMemoryDatabase.InsertIntoMetalTable("Silver",17));

    }

    @Test
    void shouldBeAbleToGetMetalByName() throws InvalidMetalDataException, MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected  = new Metal(name,credits);

        // act
        fakeInMemoryDatabase.InsertIntoMetalTable(name,credits);
        Metal actual = fakeInMemoryDatabase.selectFromMetalTable(name);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToAddQueryIntoDatabase() throws InvalidQueryDataException {
        // arrange
        int id = 1;
        QueryType queryType = QueryType.UNIT_QUERY;
        String queryContent = "How much is glob prok ?";
        QueryDto expected = new QueryDto(1,queryType,queryContent);

        // act
        QueryDto actual = fakeInMemoryDatabase.insertIntoQueryTable(queryType,queryContent);

        // assert
        assertEquals(expected,actual);
    }

}
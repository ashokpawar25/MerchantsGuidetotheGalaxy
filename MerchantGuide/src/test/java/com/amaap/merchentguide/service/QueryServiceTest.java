package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    QueryRepository queryRepository = new InMemoryQueryRepository(inMemoryDatabase);
    QueryService queryService = new QueryService(queryRepository);
    @Test
    void shouldBeAbleToCreateQuery() throws InvalidQueryDataException {
        // arrange
        int id = 1;
        QueryType queryType = QueryType.UNIT_QUERY;
        String queryContent = "How much is glob prok ?";
        QueryDto expected = new QueryDto(id,queryType,queryContent);

        // act
        QueryDto actual = queryService.create(queryType,queryContent);

        // assert
        assertEquals(expected,actual);
    }
}
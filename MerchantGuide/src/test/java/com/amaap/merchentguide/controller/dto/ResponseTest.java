package com.amaap.merchentguide.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void shouldBeAbleToCompareInstanceOfClass()
    {
        // arrange
        Response response1 = new Response(HttpStatus.OK,"message1");
        Response response2 = new Response(HttpStatus.OK,"message1");
        Response response3 = new Response(HttpStatus.BADREQUEST,"message1");
        Response response4 = new Response(HttpStatus.OK,"message2");
        Response response5 = new Response(HttpStatus.BADREQUEST,"message2");
        Object object = new Object();

        // act & assert
        assertTrue(response1.equals(response1));
        assertTrue(response1.equals(response2));
        assertFalse(response1.equals(response3));
        assertFalse(response1.equals(response4));
        assertFalse(response1.equals(response5));
        assertFalse(response1.equals(object));
        assertFalse(response1.equals(null));
    }
}
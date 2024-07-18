package com.ykv.digitalchief.api.controller;


import com.ykv.digitalchief.service.dto.EventRequest;
import com.ykv.digitalchief.service.dto.EventResponse;
import com.ykv.digitalchief.util.PostgreSQLTestContainerExtension;
import com.ykv.digitalchief.util.TestEventData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpMethod.POST;

@AutoConfigureMockMvc
@Sql(
        "classpath:schema.sql"
)
@ExtendWith(PostgreSQLTestContainerExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EventControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnIsCreateWithEventId() {
        EventRequest eventRequest = TestEventData.getEventRequest();

        HttpEntity<EventRequest> requestEntity = new HttpEntity<>(eventRequest);

        ResponseEntity<EventResponse> response = restTemplate.exchange(
                TestEventData.ADD_EVENT_URL,
                POST,
                requestEntity,
                EventResponse.class
        );

        EventResponse addedEvent = response.getBody();

        assert addedEvent != null;
        assertNotNull(addedEvent.id());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
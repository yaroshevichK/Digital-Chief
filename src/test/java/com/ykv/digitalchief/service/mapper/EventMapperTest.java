package com.ykv.digitalchief.service.mapper;

import com.ykv.digitalchief.persistence.entity.Event;
import com.ykv.digitalchief.service.dto.EventResponse;
import com.ykv.digitalchief.util.TestEventData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EventMapperTest {
    @InjectMocks
    private EventMapperImpl eventMapper;

    @Test
    void shouldMapCorrectlyAllFieldsWhenInvokeEventToEventResponse() {
        Event entity = TestEventData.getEvent();
        EventResponse response = eventMapper.eventToEventResponse(entity);

        assertEquals(entity.getDescription(), response.description());
        assertEquals(entity.getDateEvent(), response.dateEvent());
        assertEquals(entity.getTimeEvent(), response.timeEvent());
        assertEquals(entity.getCity(), response.city());
        assertEquals(entity.getCountTicket(), response.countTicket());

    }

}



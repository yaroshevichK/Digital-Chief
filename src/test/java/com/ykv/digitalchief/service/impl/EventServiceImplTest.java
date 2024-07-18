package com.ykv.digitalchief.service.impl;

import com.ykv.digitalchief.persistence.entity.Event;
import com.ykv.digitalchief.persistence.repository.EventRepository;
import com.ykv.digitalchief.service.dto.EventRequest;
import com.ykv.digitalchief.service.dto.EventResponse;
import com.ykv.digitalchief.service.mapper.EventMapper;
import com.ykv.digitalchief.util.TestEventData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {
    @InjectMocks
    private EventServiceImpl eventService;
    @Mock
    private EventRepository eventRepository;
    @Mock
    private EventMapper eventMapper;

    @Test
    void shouldReturnTrueWhenEventExist() {
        when(eventRepository.existsById(any(Long.class))).thenReturn(true);
        boolean result = eventRepository.existsById(1L);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenCandidateNotExist() {
        when(eventRepository.existsById(any(Long.class))).thenReturn(false);
        boolean result = eventRepository.existsById(1L);
        assertFalse(result);
    }

    @Test
    void shouldSavedEvent() {
        EventRequest eventRequest = TestEventData.getEventRequest();
        EventResponse eventResponse = TestEventData.getEventResponse();
        Event event = TestEventData.getEvent();

        when(eventMapper.eventRequestToEvent(eventRequest)).thenReturn(event);
        when(eventRepository.save(event)).thenReturn(event);
        when(eventMapper.eventToEventResponse(event)).thenReturn(eventResponse);

        EventResponse saveEvent = eventService.saveEvent(eventRequest);

        assertEquals(eventRequest.description(), saveEvent.description());
        assertEquals(eventRequest.dateEvent(), saveEvent.dateEvent());
        assertEquals(eventRequest.timeEvent(), saveEvent.timeEvent());
        assertEquals(eventRequest.city(), saveEvent.city());
        assertEquals(eventRequest.countTicket(), saveEvent.countTicket());
    }

    @Test
    void shouldGetCorrectListOfEvents() {
        List<Event> listEvents = TestEventData.getListEvents();
        List<EventResponse> listEventsResponse = TestEventData.getListEventsResponse();

        when(eventRepository.findAll()).thenReturn(listEvents);
        when(eventMapper.eventToEventResponse(any(Event.class))).thenReturn(listEventsResponse.get(0),
                listEventsResponse.get(1));


        List<EventResponse> result = eventService.getAllEvents();

        assertNotNull(result);
        assertEquals(listEvents.size(), result.size());
        assertEquals(listEvents.get(0).getCity(), result.get(0).city());
        assertEquals(listEvents.get(1).getDateEvent(), result.get(1).dateEvent());
    }
}
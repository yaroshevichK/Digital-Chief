package com.ykv.digitalchief.util;

import com.ykv.digitalchief.persistence.entity.Event;
import com.ykv.digitalchief.persistence.entity.TypeEvent;
import com.ykv.digitalchief.service.dto.EventRequest;
import com.ykv.digitalchief.service.dto.EventResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TestEventData {

    public static final String ADD_EVENT_URL = "/api/v1/events";
    public static final String UPDATE_EVENT_URL = "/api/v1/events/1";

    public static EventRequest getEventRequest() {
        return EventRequest.builder()
                .description("Test art gallery")
                .dateEvent(LocalDate.of(2024, 5, 3))
                .timeEvent(LocalTime.of(10, 0))
                .city("Paris")
                .typeEvent("ART")
                .countTicket(10)
                .build();
    }

    public static EventResponse getEventResponse() {
        return EventResponse.builder()
                .description("Test art gallery")
                .dateEvent(LocalDate.of(2024, 5, 3))
                .timeEvent(LocalTime.of(10, 0))
                .city("Paris")
                .typeEvent(TypeEvent.ART)
                .countTicket(10)
                .build();
    }

    public static Event getEvent() {
        return Event.builder()
                .description("Test art gallery")
                .dateEvent(LocalDate.of(2024, 5, 3))
                .timeEvent(LocalTime.of(10, 0))
                .city("Paris")
                .typeEvent(TypeEvent.ART)
                .countTicket(10)
                .build();
    }

    public static List<Event> getListEvents() {
        Event event1 = Event.builder()
                .description("Test art gallery")
                .dateEvent(LocalDate.of(2024, 5, 3))
                .timeEvent(LocalTime.of(10, 0))
                .city("Paris")
                .typeEvent(TypeEvent.ART)
                .countTicket(10)
                .build();
        Event event2 = Event.builder()
                .description("Test art gallery")
                .dateEvent(LocalDate.of(2024, 5, 9))
                .timeEvent(LocalTime.of(10, 0))
                .city("Berlin")
                .typeEvent(TypeEvent.ART)
                .countTicket(10)
                .build();
        return List.of(event1, event2);
    }

    public static List<EventResponse> getListEventsResponse() {
        EventResponse event1 = EventResponse.builder()
                .description("Test art gallery")
                .dateEvent(LocalDate.of(2024, 5, 3))
                .timeEvent(LocalTime.of(10, 0))
                .city("Paris")
                .typeEvent(TypeEvent.ART)
                .countTicket(10)
                .build();
        EventResponse event2 = EventResponse.builder()
                .description("Test art gallery")
                .dateEvent(LocalDate.of(2024, 5, 9))
                .timeEvent(LocalTime.of(10, 0))
                .city("Berlin")
                .typeEvent(TypeEvent.ART)
                .countTicket(10)
                .build();
        return List.of(event1, event2);
    }

    public static String getEventRequestJson() {
        return "{\n" +
                "    \"description\": \"Test art gallery\",\n" +
                "    \"dateEvent\": \"2024-05-03\",\n" +
                "    \"timeEvent\": \"10:00\",\n" +
                "    \"city\": \"Paris\",\n" +
                "    \"typeEvent\": \"ART\",\n" +
                "    \"countTicket\": 10\n" +
                "}";
    }

}



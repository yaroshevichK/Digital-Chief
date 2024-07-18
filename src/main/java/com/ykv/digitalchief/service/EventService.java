package com.ykv.digitalchief.service;

import com.ykv.digitalchief.service.dto.EventRequest;
import com.ykv.digitalchief.service.dto.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse saveEvent(EventRequest eventRequest);

    EventResponse getEvent(Long id);

    EventResponse updateEvent(Long id, EventRequest eventRequest);

    boolean deleteEvent(Long id);

    List<EventResponse> getAllEvents();
}

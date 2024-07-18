package com.ykv.digitalchief.service.impl;

import com.ykv.digitalchief.api.exception.EventNotFoundException;
import com.ykv.digitalchief.persistence.repository.EventRepository;
import com.ykv.digitalchief.service.EventService;
import com.ykv.digitalchief.service.dto.EventRequest;
import com.ykv.digitalchief.service.dto.EventResponse;
import com.ykv.digitalchief.service.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public EventResponse saveEvent(EventRequest eventRequest) {
        return Optional.ofNullable(eventRequest)
                .map(eventMapper::eventRequestToEvent)
                .map(eventRepository::save)
                .map(eventMapper::eventToEventResponse)
                .orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public EventResponse getEvent(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::eventToEventResponse)
                .orElseThrow(() -> new EventNotFoundException(
                        eventNotFoundMessage(id)
                ));
    }

    @Override
    public EventResponse updateEvent(Long id, EventRequest eventRequest) {
        if (!eventRepository.existsById(id)) {
            throw new EventNotFoundException(
                    eventNotFoundMessage(id)
            );
        }

        return Optional.ofNullable(eventRequest)
                .map(event -> eventMapper.eventRequestToEvent(id, event))
                .map(eventRepository::save)
                .map(eventMapper::eventToEventResponse)
                .orElseThrow();
    }

    @Override
    public boolean deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new EventNotFoundException(
                    eventNotFoundMessage(id)
            );
        }

        eventRepository.deleteById(id);
        return !eventRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::eventToEventResponse)
                .toList();
    }

    private String eventNotFoundMessage(Long id) {
        return String.format("Event with id %s not found", id);
    }
}

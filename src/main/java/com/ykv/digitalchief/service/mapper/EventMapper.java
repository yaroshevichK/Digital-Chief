package com.ykv.digitalchief.service.mapper;

import com.ykv.digitalchief.persistence.entity.Event;
import com.ykv.digitalchief.service.dto.EventRequest;
import com.ykv.digitalchief.service.dto.EventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface EventMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "typeEvent", source = "typeEvent")
    Event eventRequestToEvent(EventRequest eventRequest);

    @Mapping(target = "id", source = "id")
    Event eventRequestToEvent(Long id, EventRequest eventRequest);

    EventResponse eventToEventResponse(Event event);
}
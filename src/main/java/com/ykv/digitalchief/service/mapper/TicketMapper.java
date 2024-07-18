package com.ykv.digitalchief.service.mapper;

import com.ykv.digitalchief.persistence.entity.Ticket;
import com.ykv.digitalchief.service.dto.TicketRequest;
import com.ykv.digitalchief.service.dto.TicketResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = EventMapper.class)
public interface TicketMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "event.id", source = "eventId")
    Ticket ticketRequestToTicket(TicketRequest ticketRequest);

    @Mapping(target = "event.id", source = "eventId")
    Ticket ticketRequestUpdToTicket(TicketRequest ticketRequest);

    TicketResponse ticketToTicketResponse(Ticket ticket);
}
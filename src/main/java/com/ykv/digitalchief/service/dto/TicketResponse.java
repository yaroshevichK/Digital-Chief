package com.ykv.digitalchief.service.dto;

import com.ykv.digitalchief.persistence.entity.TypeTicket;
import lombok.Builder;

@Builder
public record TicketResponse(
        Long id,
        TypeTicket typeTicket,
        Double price,
        Integer hall,
        Integer rowHall,
        Integer seat,
        EventResponse event
) {
}

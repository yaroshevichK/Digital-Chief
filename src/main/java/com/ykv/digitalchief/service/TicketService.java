package com.ykv.digitalchief.service;

import com.ykv.digitalchief.service.dto.TicketRequest;
import com.ykv.digitalchief.service.dto.TicketResponse;

import java.util.List;

public interface TicketService {
    TicketResponse saveTicket(TicketRequest ticketRequest);

    TicketResponse getTicket(Long id);

    TicketResponse updateTicket(TicketRequest ticketRequest);

    boolean deleteTicket(Long id);

    List<TicketResponse> getAllTickets();
}

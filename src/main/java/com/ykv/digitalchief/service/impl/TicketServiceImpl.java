package com.ykv.digitalchief.service.impl;

import com.ykv.digitalchief.api.exception.TicketNotFoundException;
import com.ykv.digitalchief.persistence.repository.TicketRepository;
import com.ykv.digitalchief.service.TicketService;
import com.ykv.digitalchief.service.dto.TicketRequest;
import com.ykv.digitalchief.service.dto.TicketResponse;
import com.ykv.digitalchief.service.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public TicketResponse saveTicket(TicketRequest ticketRequest) {
        return Optional.ofNullable(ticketRequest)
                .map(ticketMapper::ticketRequestToTicket)
                .map(ticketRepository::save)
                .map(ticketMapper::ticketToTicketResponse)
                .orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public TicketResponse getTicket(Long id) {
        return ticketRepository.findById(id)
                .map(ticketMapper::ticketToTicketResponse)
                .orElseThrow(() -> new TicketNotFoundException(
                        ticketNotFoundMessage(id)
                ));
    }

    @Override
    public TicketResponse updateTicket(TicketRequest ticketRequest) {
        boolean ticketIsExist = Optional.ofNullable(ticketRequest.id())
                .map(ticketRepository::existsById)
                .orElseThrow(() -> new TicketNotFoundException("Bad ticket request"));

        if (!ticketIsExist) {
            throw new TicketNotFoundException(
                    ticketNotFoundMessage(ticketRequest.id())
            );
        }

        return Optional.of(ticketRequest)
                .map(ticketMapper::ticketRequestUpdToTicket)
                .map(ticketRepository::save)
                .map(ticketMapper::ticketToTicketResponse)
                .orElseThrow();
    }

    @Override
    public boolean deleteTicket(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new TicketNotFoundException(
                    ticketNotFoundMessage(id)
            );
        }

        ticketRepository.deleteById(id);
        return !ticketRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(ticketMapper::ticketToTicketResponse)
                .toList();
    }

    private String ticketNotFoundMessage(Long id) {
        return String.format("Ticket with id %s not found", id);
    }
}

package com.ykv.digitalchief.api.controller;

import com.ykv.digitalchief.service.TicketService;
import com.ykv.digitalchief.service.dto.TicketRequest;
import com.ykv.digitalchief.service.dto.TicketResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping("api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @Operation(summary = "Add new ticket", tags = "Tickets")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketResponse> saveTicket(@RequestBody @Valid TicketRequest ticketRequest) {
        TicketResponse event = ticketService.saveTicket(ticketRequest);
        return new ResponseEntity<>(event, CREATED);
    }

    @Operation(summary = "Get ticket by id", tags = "Tickets")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketResponse> getTicket(@PathVariable("id") @NotNull Long id) {
        return new ResponseEntity<>(ticketService.getTicket(id), OK);
    }

    @Operation(summary = "Update ticket", tags = "Tickets")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketResponse> updateTicket(@RequestBody @Valid TicketRequest eventRequest) {
        TicketResponse ticket = ticketService.updateTicket(eventRequest);
        return new ResponseEntity<>(ticket, OK);
    }

    @Operation(summary = "Delete ticket by id", tags = "Tickets")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") @NotNull Long id) {
        return new ResponseEntity<>(ticketService.deleteTicket(id) ? OK : HttpStatus.NOT_MODIFIED);
    }

    @Operation(summary = "Get all tickets", tags = "Tickets")
    @GetMapping()
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(), OK);
    }
}

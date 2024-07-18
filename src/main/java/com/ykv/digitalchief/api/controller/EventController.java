package com.ykv.digitalchief.api.controller;

import com.ykv.digitalchief.service.EventService;
import com.ykv.digitalchief.service.dto.EventRequest;
import com.ykv.digitalchief.service.dto.EventResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Events", description = "Events")
@Validated
@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @Operation(summary = "Add new event", tags = "Events")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<EventResponse> saveEvent(@RequestBody @Valid EventRequest eventRequest) {
        EventResponse event = eventService.saveEvent(eventRequest);
        return new ResponseEntity<>(event, CREATED);
    }

    @Operation(summary = "Get event by id", tags = "Events")
    @GetMapping(value = "/{id}")
    public ResponseEntity<EventResponse> getEvent(@PathVariable("id") @NotNull Long id) {
        return new ResponseEntity<>(eventService.getEvent(id), OK);
    }

    @Operation(summary = "Update event", tags = "Events")
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<EventResponse> updateEvent(
            @PathVariable("id") @NotNull Long id,
            @RequestBody @Valid EventRequest eventRequest) {
        EventResponse event = eventService.updateEvent(id, eventRequest);
        return new ResponseEntity<>(event, OK);
    }

    @Operation(summary = "Delete event by id", tags = "Events")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") @NotNull Long id) {
        return new ResponseEntity<>(eventService.deleteEvent(id) ? OK : HttpStatus.NOT_MODIFIED);
    }

    @Operation(summary = "Get all events", tags = "Events")
    @GetMapping()
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), OK);
    }
}

package com.ykv.digitalchief.service.dto;

import com.ykv.digitalchief.service.validation.TypeTicketValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record TicketRequest(
        Long id,
        @NotNull(message = "Type ticket must not be null")
        @TypeTicketValue
        @Schema(defaultValue = "SIMPLE", description = "Type tickets (SIMPLE, VIP, VIP2)")
        String typeTicket,
        @NotNull(message = "Price must not be null")
        @Schema(defaultValue = "80", description = "Price tickets")
        Double price,
        @NotNull(message = "Hall must not be null")
        @Schema(defaultValue = "2", description = "Hall")
        Integer hall,
        @NotNull(message = "Row hall must not be null")
        @Schema(defaultValue = "5", description = "Row hall")
        Integer rowHall,
        @NotNull(message = "Seat must not be null")
        @Schema(defaultValue = "18", description = "Seat")
        Integer seat,
        @NotNull(message = "Event must not be null")
        @Schema(defaultValue = "1", description = "Event id")
        Long eventId
) implements Serializable {
}

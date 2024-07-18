package com.ykv.digitalchief.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ykv.digitalchief.service.validation.TypeEventValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record EventRequest(
        @NotBlank(message = "Description must not be null")
        @Length(max = 255, message = "Length description is too long")
        @Schema(defaultValue = "Scorpions", description = "Name events")
        String description,
        @NotNull(message = "Date event must not be null")
        @Schema(defaultValue = "2024-08-15", description = "Date event")
        LocalDate dateEvent,
        @NotNull(message = "Time event must not be null")
        @JsonFormat(pattern = "HH:mm")
        @Schema(defaultValue = "18:00", description = "Time event", type = "String", format = "HH:mm")
        LocalTime timeEvent,
        @NotBlank(message = "City must not be null")
        @Length(max = 50, message = "Length city is too long")
        @Schema(defaultValue = "Berlin", description = "City")
        String city,
        @NotNull(message = "Type event must not be null")
        @TypeEventValue
        @Schema(defaultValue = "CONCERT", description = "Type event")
        String typeEvent,
        @NotNull(message = "Count ticket must not be null")
        @Min(value = 0, message = "Count ticket must be positive")
        @Schema(defaultValue = "170", description = "Count tickets")
        Integer countTicket
) implements Serializable {
}

package com.ykv.digitalchief.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ykv.digitalchief.persistence.entity.TypeEvent;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record EventResponse(
        Long id,
        String description,
        LocalDate dateEvent,
        @JsonFormat(pattern = "HH:mm")
        @Schema(type = "String", format = "HH:mm")
        LocalTime timeEvent,
        String city,
        TypeEvent typeEvent,
        Integer countTicket
) implements Serializable {
}

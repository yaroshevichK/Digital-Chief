package com.ykv.digitalchief.api.controller;

import com.ykv.digitalchief.service.EventService;
import com.ykv.digitalchief.service.dto.EventRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.ykv.digitalchief.util.TestEventData.ADD_EVENT_URL;
import static com.ykv.digitalchief.util.TestEventData.UPDATE_EVENT_URL;
import static com.ykv.digitalchief.util.TestEventData.getEventRequest;
import static com.ykv.digitalchief.util.TestEventData.getEventRequestJson;
import static com.ykv.digitalchief.util.TestEventData.getEventResponse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EventController.class)
@AutoConfigureMockMvc(addFilters = false)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Test
    void shouldReturn201WhenAddEventIsSuccessful() throws Exception {
        EventRequest eventRequest = getEventRequest();

        when(eventService.saveEvent(eventRequest)).thenReturn(
                getEventResponse()
        );

        mockMvc.perform(post(ADD_EVENT_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getEventRequestJson()
                        )
                )
                .andExpect(status().isCreated());
    }


    @Test
    void shouldReturnCreatedWhenUpdateIsSuccessful() throws Exception {
        EventRequest eventRequest = getEventRequest();

        when(eventService.updateEvent(1L, eventRequest)).thenReturn(
                getEventResponse()
        );

        mockMvc.perform(put(UPDATE_EVENT_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getEventRequestJson()
                        )
                )
                .andExpect(status().isOk());
    }

}
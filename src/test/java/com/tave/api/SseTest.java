package com.tave.api;

import com.tave.api.SSE.SseController;
import com.tave.api.SSE.SseService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SseTest {

    private MockMvc mockMvc;

    @Mock
    private SseService sseService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new SseController(sseService)).build();
    }

    @Test
    public void testSseConnection() throws Exception {
        Long clientId = 1L;
        String url = "/sse/connect/" + clientId;

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.TEXT_EVENT_STREAM_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        verify(sseService).addSseConnection(anyLong());
    }
}

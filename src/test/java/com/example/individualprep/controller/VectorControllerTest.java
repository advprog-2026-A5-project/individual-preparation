package com.example.individualprep.controller;

import com.example.individualprep.dto.VectorRequest;
import com.example.individualprep.dto.VectorResponse;
import com.example.individualprep.service.VectorUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VectorController.class)
class VectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VectorUtility vectorUtility;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void whenDotProductCalled_returnCorrectScalarResult() throws Exception {
        double[] v1 = {1.5, 2.0, 50.0};
        double[] v2 = {2, 0.5, 0.1};
        VectorRequest vectorRequest = new VectorRequest(v1, v2, 0);
        VectorResponse expectedResponse = new VectorResponse(9.0);
        when(vectorUtility.dotProduct(any(double[].class), any(double[].class))).thenReturn(9.0);
        mockMvc.perform(post("/api/vector/dotProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vectorRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedResponse))); // You can add assertions here
    }
}
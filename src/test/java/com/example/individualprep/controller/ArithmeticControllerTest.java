package com.example.individualprep.controller;

import com.example.individualprep.dto.ArithmeticRequest;
import com.example.individualprep.dto.ArithmeticResponse;
import com.example.individualprep.dto.VectorRequest;
import com.example.individualprep.dto.VectorResponse;
import com.example.individualprep.service.ArithmeticUtility;
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

@WebMvcTest(ArithmeticController.class)
class ArithmeticControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ArithmeticUtility arithmeticUtility;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void whenSubstractCalled_returnCorrectResult() throws Exception {
        ArithmeticRequest arithmeticRequest = new ArithmeticRequest(3.0, 4.0, 0);
        ArithmeticResponse expectedResponse = new ArithmeticResponse(-1.0);
        when(arithmeticUtility.subtract(3.0, 4.0)).thenReturn(-1.0);
        mockMvc.perform(post("/api/arithmetic/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(arithmeticRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    void whenDivideCalled_returnCorrectResult() throws Exception {
        ArithmeticRequest arithmeticRequest = new ArithmeticRequest(10.0, 2.0, 0);
        ArithmeticResponse expectedResponse = new ArithmeticResponse(5.0);

        when(arithmeticUtility.divide(10.0, 2.0)).thenReturn(5.0);

        mockMvc.perform(post("/api/arithmetic/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(arithmeticRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedResponse)));

    }
                        
    @Test
    void whenMultiplyCalled_returnCorrectResult() throws Exception {
        ArithmeticRequest arithmeticRequest = new ArithmeticRequest(3.0, 4.0, 0);
        ArithmeticResponse expectedResponse = new ArithmeticResponse(12.0);
        when(arithmeticUtility.multiply(3.0, 4.0)).thenReturn(12.0);
        mockMvc.perform(post("/api/arithmetic/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(arithmeticRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedResponse)));
    }
}
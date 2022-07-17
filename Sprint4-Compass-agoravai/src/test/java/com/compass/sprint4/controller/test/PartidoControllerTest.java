package com.compass.sprint4.controller.test;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PartidoControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void save() throws Exception {
        URI uri = new URI("/partidos");

        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(getString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201));

    }

    @Test
    void saveException() throws Exception {
        URI uri = new URI("/partidos");

        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(getStringException())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));

    }


    private String getString() {
        return "{\"nome\":\"abc\"," +
                "\"sigla\":\"fgh\"," +
                "\"ideologia\":\"Direita\"," +
                "\"dataFundacao\":\"30/12/2100\"}";
    }

    private String getStringException() {
        return "{\"nome\":\"\"," +
                "\"sigla\":\"fgh\"," +
                "\"ideologia\":\"Direita\"," +
                "\"dataFundacao\":\"30/12/2100\"}";
    }
}

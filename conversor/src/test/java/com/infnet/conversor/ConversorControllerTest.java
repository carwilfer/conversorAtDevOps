package com.infnet.conversor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConversorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testKmToMiles() throws Exception {
        mockMvc.perform(get("/conversor/kmToMiles/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.21371"));
    }

    @Test
    public void testCelsiusToFahrenheit() throws Exception {
        mockMvc.perform(get("/conversor/celsiusToFahrenheit/0"))
                .andExpect(status().isOk())
                .andExpect(content().string("32.0"));
    }
}

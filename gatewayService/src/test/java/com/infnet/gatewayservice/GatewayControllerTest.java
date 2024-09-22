package com.infnet.gatewayservice;

import com.infnet.gatewayservice.client.ConversorClient;
import com.infnet.gatewayservice.client.DatabaseClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class GatewayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConversorClient conversorClient;

    @MockBean
    private DatabaseClient databaseClient;

    @Test
    public void testConvertKmToMiles() throws Exception {
        when(conversorClient.convertKmToMiles(10.0)).thenReturn(6.21371);

        mockMvc.perform(get("/api/convertKmToMiles/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.21371"));
    }

    @Test
    public void testConvertCelsiusToFahrenheit() throws Exception {
        when(conversorClient.convertCelsiusToFahrenheit(0.0)).thenReturn(32.0);

        mockMvc.perform(get("/api/convertCelsiusToFahrenheit/0"))
                .andExpect(status().isOk())
                .andExpect(content().string("32.0"));
    }
}

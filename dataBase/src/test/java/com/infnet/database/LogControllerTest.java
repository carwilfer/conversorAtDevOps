package com.infnet.database;

import com.infnet.database.model.ConversaoLog;
import com.infnet.database.repository.ConversaoLogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class LogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConversaoLogRepository logRepository;

    @Test
    public void testSalvarLog() throws Exception {
        ConversaoLog log = new ConversaoLog(1L, "Km to Miles", 10.0, 6.21371, LocalDateTime.now());
        when(logRepository.save(any(ConversaoLog.class))).thenReturn(log);

        mockMvc.perform(post("/logs/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tipoConversao\":\"Km to Miles\", \"valorEntrada\":10, \"valorSaida\":6.21371}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoConversao").value("Km to Miles"));
    }
}

package com.infnet.gatewayservice.controller;

import com.infnet.gatewayservice.client.ConversorClient;
import com.infnet.gatewayservice.client.DatabaseClient;
import com.infnet.gatewayservice.dto.ConversaoLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class GatewayController {

    @Autowired
    private ConversorClient conversorClient;

    @Autowired
    private DatabaseClient databaseClient;

    // Método para converter Km para Milhas
    @GetMapping("/convertKmToMiles/{kilometers}")
    public ResponseEntity<Double> convertKmToMiles(@PathVariable Double kilometers) {
        Double miles = conversorClient.convertKmToMiles(kilometers);

        ConversaoLogDTO log = new ConversaoLogDTO();
        log.setTipoConversao("Km to Miles");
        log.setValorEntrada(kilometers);
        log.setValorSaida(miles);
        log.setDataHora(LocalDateTime.now());

        databaseClient.salvarLog(log);

        return ResponseEntity.ok(miles);
    }

    // Método para converter Celsius para Fahrenheit
    @GetMapping("/convertCelsiusToFahrenheit/{celsius}")
    public ResponseEntity<Double> convertCelsiusToFahrenheit(@PathVariable Double celsius) {
        Double fahrenheit = conversorClient.convertCelsiusToFahrenheit(celsius);
        return ResponseEntity.ok(fahrenheit);
    }
}

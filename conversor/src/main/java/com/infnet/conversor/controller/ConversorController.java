package com.infnet.conversor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversor")
public class ConversorController {

    //para converter quilômetros para milhas
    @GetMapping("/kmToMiles/{kilometers}")
    public ResponseEntity<Double> kmToMiles(@PathVariable Double kilometers) {
        Double miles = kilometers * 0.621371;
        return ResponseEntity.ok(miles);
    }

    //para converter Celsius para Fahrenheit
    @GetMapping("/celsiusToFahrenheit/{celsius}")
    public ResponseEntity<Double> celsiusToFahrenheit(@PathVariable Double celsius) {
        Double fahrenheit = (celsius * 9/5) + 32;
        return ResponseEntity.ok(fahrenheit);
    }
}

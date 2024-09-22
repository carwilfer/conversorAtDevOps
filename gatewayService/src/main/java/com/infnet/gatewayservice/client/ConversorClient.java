package com.infnet.gatewayservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "conversor-service", url = "http://localhost:8093")
@FeignClient(name = "conversor-service", url = "http://conversor-service:8093")
public interface ConversorClient {

    @GetMapping("/conversor/kmToMiles/{kilometers}")
    Double convertKmToMiles(@PathVariable("kilometers") Double kilometers);

    @GetMapping("/conversor/celsiusToFahrenheit/{celsius}")
    Double convertCelsiusToFahrenheit(@PathVariable("celsius") Double celsius);
}
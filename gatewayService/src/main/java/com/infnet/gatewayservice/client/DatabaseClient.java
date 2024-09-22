package com.infnet.gatewayservice.client;

import com.infnet.gatewayservice.dto.ConversaoLogDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "database-service", url = "http://localhost:8095")
@FeignClient(name = "database-service", url = "http://database-service:8095")
public interface DatabaseClient {

    @PostMapping("/logs/salvar")
    ConversaoLogDTO salvarLog(@RequestBody ConversaoLogDTO log);
}

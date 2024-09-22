package com.infnet.database.controller;

import com.infnet.database.model.ConversaoLog;
import com.infnet.database.repository.ConversaoLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private ConversaoLogRepository logRepository;

    @PostMapping("/salvar")
    public ConversaoLog salvarLog(@RequestBody ConversaoLog log) {
        return logRepository.save(log);
    }
}

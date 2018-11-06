package com.boott.boott.controller;

import com.boott.boott.config.GlobalProperties;
import com.boott.boott.config.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GController {

    @Autowired
    private GlobalProperties globalProperties;

    @Autowired
    private YAMLConfig yamlConfig;

    @GetMapping("/email")
    String email() {
        return globalProperties.getEmail();
    }

    @GetMapping("/threadn")
    Integer threadn() {
        return globalProperties.getThreadPool();
    }

    @GetMapping("/name")
    String name() {
        return yamlConfig.getName();
    }

    @GetMapping("/somenum")
    Integer num() {
        return yamlConfig.getSomenumber();
    }
}
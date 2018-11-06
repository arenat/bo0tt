package com.boott.boott.controller;

import com.boott.boott.config.GlobalProperties;
import com.boott.boott.config.YAMLConfig;
import com.boott.boott.entities.People;
import com.boott.boott.repository.PeopleRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.List;

@Validated
@RestController
public class GController {

    @Autowired
    private GlobalProperties globalProperties;

    @Autowired
    private YAMLConfig yamlConfig;

    @Autowired
    private PeopleRepository peopleRepository;

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

    @GetMapping(path = "/all")
    public Iterable<People> all() {
        return peopleRepository.findAll();
    }

    @GetMapping(path = "/illegal")
    public String illegal() {
        throw new RuntimeException();
    }

    @GetMapping(path = "/max")
    public Integer max(@Param("m") @Max(256) Integer m) {
        return m;
    }

    @GetMapping(path = "/len")
    public String len(@Param("len") @Length(max = 5) String len) {
        return len;
    }
}
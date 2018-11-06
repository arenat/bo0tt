package com.boott.boott.config;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Data
@Configuration // marks the class as a source of bean definitions
@EnableConfigurationProperties // this annotation is used to enable @ConfigurationProperties annotated beans in the Spring application
@ConfigurationProperties //  binds and validates the external configurations to a configuration class
@Validated
@PropertySource("classpath:yml.properties")
public class YAMLConfig {
    private String name;
    private String environment;
    private List<String> servers = new ArrayList<>();
    @Max(1000)
    private Integer somenumber;
    // standard getters and setters
}

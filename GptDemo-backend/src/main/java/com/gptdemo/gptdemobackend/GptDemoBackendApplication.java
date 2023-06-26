package com.gptdemo.gptdemobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class GptDemoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GptDemoBackendApplication.class, args);
    }

}

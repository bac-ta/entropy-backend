package com.demo.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author bac-ta
 */
@SpringBootApplication
public class LegacyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LegacyApplication.class, args);
    }
}


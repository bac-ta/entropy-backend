package com.entropy.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bac-ta
 */
@SpringBootApplication
public class EntropyBackEndApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(EntropyBackEndApplication.class, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


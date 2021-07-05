package com.adsware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Main class.
 *
 * @author alfiguer
 */
@SpringBootApplication
@EntityScan("com.adswaresystem.clever.hotelier.clients.entity")
public class AdswareWebArchetypeApplication {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(AdswareWebArchetypeApplication.class, args);
    }

}

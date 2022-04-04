package com.vin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.vin")
public class Application {

    public static void main(String[] args) {

        try {
            ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

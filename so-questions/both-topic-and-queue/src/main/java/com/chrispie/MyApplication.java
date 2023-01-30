package com.chrispie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MyApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}

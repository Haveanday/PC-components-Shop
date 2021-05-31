package com.example.PCcomponentsShop;

import Repository.ComponentsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;

@EnableScheduling
@SpringBootApplication
@EnableSwagger2

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello there!");
        SpringApplication.run(Application.class, args);

    }
}
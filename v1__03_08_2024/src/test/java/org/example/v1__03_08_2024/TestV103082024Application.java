package org.example.v1__03_08_2024;

import org.springframework.boot.SpringApplication;

public class TestV103082024Application {

    public static void main(String[] args) {
        SpringApplication.from(V103082024Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}

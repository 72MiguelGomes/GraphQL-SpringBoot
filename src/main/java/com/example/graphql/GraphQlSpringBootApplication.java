package com.example.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.graphql")
public class GraphQlSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphQlSpringBootApplication.class, args);
  }

}


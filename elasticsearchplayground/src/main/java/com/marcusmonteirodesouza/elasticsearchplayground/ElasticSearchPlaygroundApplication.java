package com.marcusmonteirodesouza.elasticsearchplayground;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ElasticSearchPlaygroundApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchPlaygroundApplication.class, args);
    }
}

package com.example.agent_rnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AgentRndApplication {

    public static void main(String[] args) {

        SpringApplication.run(AgentRndApplication.class, args);
    }

}

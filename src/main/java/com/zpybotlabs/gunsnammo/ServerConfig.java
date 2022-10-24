package com.zpybotlabs.gunsnammo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  //Initialized as bean
  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      //code executed when application starts
      LOGGER.info("Well-done app run successfully!");
    };
  }

}

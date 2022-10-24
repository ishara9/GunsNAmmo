package com.zpybotlabs.gunsnammo;

import com.zpybotlabs.gunsnammo.dao.GunFakeRepo;
import com.zpybotlabs.gunsnammo.dao.GunRepo;
import com.zpybotlabs.gunsnammo.dao.GunRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {

  @Value("${app.useFakeGunRepo:false}")
  private Boolean useFakeGunRepo;

  //Initialized as bean
  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
      //code executed when application starts
      System.out.println("Well-done app run successfully!");
    };

  }

  @Bean
  GunRepo gunRepo() {
    System.out.println("useFakeGunRepo = " + useFakeGunRepo);
    return useFakeGunRepo ? new GunFakeRepo() : new GunRepository();
  }
}

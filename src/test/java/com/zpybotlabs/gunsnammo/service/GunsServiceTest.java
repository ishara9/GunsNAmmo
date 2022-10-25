package com.zpybotlabs.gunsnammo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import com.zpybotlabs.gunsnammo.dao.GunsRepository;
import com.zpybotlabs.gunsnammo.dto.PartialGunDTO;
import com.zpybotlabs.gunsnammo.exception.ServerRequestException;
import com.zpybotlabs.gunsnammo.pojo.Gun;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class GunsServiceTest {

  private GunsService gunsService;

  @Autowired
  private GunsRepository gunsRepository;

  @BeforeEach
  void setUp() {
    gunsService = new GunsService(gunsRepository);
  }

  @AfterEach
  void tearDown() {
    gunsRepository.deleteAll();
  }

  @Test
  void getGuns_whenAtLeastOneGunAvailable_returnGun() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t");
    gunsRepository.saveAll(List.of(gun));
    assertEquals("name", gunsService.getGuns().get(0).getName());
  }

  @Test
  void getGun_whenAGunIsThere_getThatGun() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t");
    gunsRepository.saveAll(List.of(gun));
    assertEquals("name", gunsService.getGun(1L).getName());
  }

  @Test
  void createGuns_whenGunIsAvailable_shouldCreateAGun() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t");
    gunsService.createGuns(List.of(gun));
    assertEquals("name", gunsService.getGun(1L).getName());
  }

  @Test()
  void deleteGunById_whenGunIsDeleted_expectedException() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t");
    gunsRepository.saveAll(List.of(gun));
    gunsService.deleteGunById(1L);
    assertThrowsExactly(ServerRequestException.class , () -> gunsService.getGun(1L));
  }

  @Test
  void updateGun_changedDetails_expectChanges() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t");
    gunsRepository.saveAll(List.of(gun));
    gunsService.updateGun(new Gun(1L, "name2", "email2@mail.com", "no secret"), 1L);
    assertEquals("name2", gunsService.getGun(1L).getName());
  }

  @Test
  void updatePartialGun_whenChangesPatched_getPatchedChanges() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t");
    gunsRepository.saveAll(List.of(gun));
    gunsService.updatePartialGun(new PartialGunDTO("namePatched"), 1L);
    assertEquals("namePatched", gunsService.getGun(1L).getName());
  }


}
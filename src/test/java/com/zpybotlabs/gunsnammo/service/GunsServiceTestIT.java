package com.zpybotlabs.gunsnammo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import com.zpybotlabs.gunsnammo.dto.GunDTO;
import com.zpybotlabs.gunsnammo.exception.ServerRequestException;
import com.zpybotlabs.gunsnammo.model.Gun;
import com.zpybotlabs.gunsnammo.repository.GunsRepository;
import com.zpybotlabs.gunsnammo.service.impl.GunsServiceImpl;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = false)
class GunsServiceTestIT {

  private GunsService gunsService;

  @Autowired
  private GunsRepository gunsRepository;

  @BeforeEach
  void setUp() {
    gunsService = new GunsServiceImpl(gunsRepository, new ModelMapper());
  }

  @AfterEach
  void tearDown() {
    gunsRepository.deleteAll();
  }

  @Test
  void getGuns_whenAtLeastOneGunAvailable_returnGun() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    gunsRepository.saveAll(List.of(gun));
    assertEquals("name", gunsService.getGuns().get(0).getName());
  }

  @Test
  void getGun_whenAGunIsThere_getThatGun() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    gunsRepository.saveAll(List.of(gun));
    assertEquals("name", gunsService.getGun(1L).getName());
  }

  @Test
  void createGuns_whenGunIsAvailable_shouldCreateAGun() {
    GunDTO GunDTO = new GunDTO(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    gunsService.createGuns(List.of(GunDTO));
    assertEquals("name", gunsService.getGun(1L).getName());
  }

  @Test()
  void deleteGunById_whenGunIsDeleted_expectedException() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    gunsRepository.saveAll(List.of(gun));
    gunsService.deleteGunById(1L);
    assertThrowsExactly(ServerRequestException.class, () -> gunsService.getGun(1L));
  }

  @Test
  void updateGun_changedDetails_expectChanges() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    gunsRepository.saveAll(List.of(gun));
    gunsService.updateGun(new GunDTO(1L, "name2", "email2@mail.com", "no secret", Collections.emptySet()), 1L);
    assertEquals("name2", gunsService.getGun(1L).getName());
  }

  @Test
  void updatePartialGun_whenChangesPatched_getPatchedChanges() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    gunsRepository.saveAll(List.of(gun));
    gunsService.updatePartialGun(GunDTO.builder().name("namePatched").build(), 1L);
    assertEquals("namePatched", gunsService.getGun(1L).getName());
  }


}
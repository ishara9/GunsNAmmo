package com.zpybotlabs.gunsnammo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.zpybotlabs.gunsnammo.dto.GunDTO;
import com.zpybotlabs.gunsnammo.model.Gun;
import com.zpybotlabs.gunsnammo.repository.GunsRepository;
import com.zpybotlabs.gunsnammo.service.impl.GunsServiceImpl;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DataJpaTest(showSql = false)
class GunsServiceTest {

  private GunsService gunsService;

  @MockBean
  private GunsRepository gunsRepository;

  @Spy
  ModelMapper modelMapper;

  @BeforeEach
  void setUp() {
    gunsService = new GunsServiceImpl(gunsRepository, modelMapper);
  }

  @AfterEach
  void tearDown() {
    gunsRepository.deleteAll();
  }

  @Test
  void getGuns_whenAtLeastOneGunAvailable_returnGun() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    when(gunsRepository.findAll()).thenReturn(List.of(gun));
    assertEquals("name", gunsService.getGuns().get(0).getName());
  }

  @Test
  void getGun_whenAGunIsThere_getThatGun() {
    Gun gun = new Gun(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    when(gunsRepository.findAll()).thenReturn(List.of(gun));
    assertEquals("name", gunsService.getGun(1L).getName());
  }

  @Test
  void createGuns_whenGunIsAvailable_shouldCreateAGun() {
    GunDTO gun = new GunDTO(1L, "name", "email@mail.com", "1x3i3t", Collections.emptySet());
    gunsService.createGuns(List.of(gun));
    verify(gunsRepository, atMostOnce()).saveAll(anyList());
  }

  @Test()
  void deleteGunById_whenGunIsDeleted_calledDeleteMethodAtLeastOnce() {
    gunsService.deleteGunById(1L);
    verify(gunsRepository, atLeastOnce()).deleteById(any());
  }

}
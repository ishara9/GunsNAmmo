package com.zpybotlabs.gunsnammo.repository;

import com.zpybotlabs.gunsnammo.model.Gun;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional //default rollback
class GunsRepositoryTest {

  @Autowired
  private GunsRepository gunsRepository;

  @Test
  @Order(1)
  public void testAdd() {
    Gun gun = new Gun();
    gun.setGunId(1L);
    Gun gunResp = gunsRepository.save(gun);
    Assertions.assertNotNull(gunResp);
  }

  @Test
  @Order(2)
  public void testFindAll() {
    List<Gun> guns = gunsRepository.findAll();
    Assertions.assertEquals(0, guns.size());
  }



}
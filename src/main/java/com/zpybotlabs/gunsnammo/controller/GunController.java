package com.zpybotlabs.gunsnammo.controller;

import com.zpybotlabs.gunsnammo.pojo.Gun;
import com.zpybotlabs.gunsnammo.service.GunService;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1/guns")
@RestController
public class GunController {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private GunService gunService;

  @GetMapping
  List<Gun> getGuns() {
    return gunService.getGuns();
  }

  @GetMapping(path = "{gunId}")
  Gun getGun(@Valid @PathVariable Long gunId) {
    LOGGER.info("POST request...");
    return gunService.getGun(gunId);
  }

  @PostMapping
  void addGun(@Valid @RequestBody Gun gun) {
    LOGGER.info("POST request...");
    LOGGER.debug("{}", gun);
  }

  @DeleteMapping(path = "{gunId}")
  void deleteGun(@PathVariable Long gunId) {
    LOGGER.debug("Delete request for gunId: {}", gunId);
  }

  @PutMapping
  void updateGun(@RequestBody Gun gun) {
    LOGGER.info("Update request");
    LOGGER.debug("{}", gun);
  }
}

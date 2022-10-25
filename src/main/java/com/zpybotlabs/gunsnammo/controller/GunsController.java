package com.zpybotlabs.gunsnammo.controller;

import com.zpybotlabs.gunsnammo.exception.ClientRequestException;
import com.zpybotlabs.gunsnammo.model.Gun;
import com.zpybotlabs.gunsnammo.service.impl.GunsServiceImpl;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@AllArgsConstructor
public class GunsController {

  private final GunsServiceImpl gunsService;

  @GetMapping
  List<Gun> getGuns() {
    return gunsService.getGuns();
  }

  @GetMapping(path = "{gunId}")
  Gun getGun(@PathVariable Long gunId) {
    log.info("POST request...");
    return gunsService.getGun(gunId);
  }

  @PostMapping
  void addGun(@RequestBody Gun gun) {
    log.info("POST request...");
    log.debug("{}", gun);
  }

  @DeleteMapping(path = "{gunId}")
  void deleteGun(@PathVariable Long gunId) {
    log.debug("Delete request for gunId: {}", gunId);
  }

  @PutMapping
  void updateGun(@RequestBody Gun gun) {
    log.info("Update request");
    log.debug("{}", gun);
  }

  @GetMapping(path = "{gunId}/ex")
  Gun getGunEx(@PathVariable Long gunId) {
    throw new ClientRequestException("gunId : " + gunId);
  }
}

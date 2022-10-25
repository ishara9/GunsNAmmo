package com.zpybotlabs.gunsnammo.controller;

import com.zpybotlabs.gunsnammo.dto.PartialGunDTO;
import com.zpybotlabs.gunsnammo.pojo.Gun;
import com.zpybotlabs.gunsnammo.service.GunsService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v2/guns")
@RestController
public class GunsControllerV2 {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private GunsService gunsService;

  @GetMapping
  ResponseEntity<List<Gun>> getGuns() {
    return new ResponseEntity<>(gunsService.getGuns(), HttpStatus.OK);
  }

  @GetMapping(path = "{gunId}")
  ResponseEntity<Gun> getGun(@PathVariable Long gunId) {
    return new ResponseEntity<>(gunsService.getGun(gunId), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<Void> addGuns(@RequestBody List<Gun> guns) {
    LOGGER.info("POST request...");
    gunsService.createGuns(guns);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(path = "{gunId}")
  ResponseEntity<Void> updateGun(@RequestBody Gun gun, @PathVariable Long gunId) {
    LOGGER.info("Update request");
    gunsService.updateGun(gun, gunId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PatchMapping(path = "{gunId}")
  ResponseEntity<Void> updatePatchGun(@RequestBody PartialGunDTO partialGunDTO,
      @PathVariable Long gunId) {
    LOGGER.info("Patch request");
    gunsService.updatePartialGun(partialGunDTO, gunId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(path = "{gunId}")
  ResponseEntity<Void> deleteGun(@PathVariable Long gunId) {
    LOGGER.info("Delete request for gunId: " + gunId);
    gunsService.deleteGunById(gunId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

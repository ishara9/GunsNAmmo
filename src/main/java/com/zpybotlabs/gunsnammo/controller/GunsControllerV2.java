package com.zpybotlabs.gunsnammo.controller;

import com.zpybotlabs.gunsnammo.dto.GunDTO;
import com.zpybotlabs.gunsnammo.service.impl.GunsServiceImpl;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import javax.validation.Valid;

@RequestMapping(path = "/api/v2/guns")
@RestController
@Slf4j
@AllArgsConstructor
public class GunsControllerV2 {

  private final GunsServiceImpl gunsService;

  @GetMapping
  ResponseEntity<List<GunDTO>> getGuns() {
    return new ResponseEntity<>(gunsService.getGuns(), HttpStatus.OK);
  }

  @GetMapping(path = "{gunId}")
  ResponseEntity<GunDTO> getGun(@PathVariable Long gunId) {
    return new ResponseEntity<>(gunsService.getGun(gunId), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<Void> addGuns(@Valid @RequestBody List<GunDTO> guns) {
    gunsService.createGuns(guns);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(path = "{gunId}")
  ResponseEntity<Void> updateGun(@RequestBody GunDTO GunDTO, @PathVariable Long gunId) {
    gunsService.updateGun(GunDTO, gunId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PatchMapping(path = "{gunId}")
  ResponseEntity<Void> updatePatchGun(@RequestBody GunDTO partialGunDTO,
      @PathVariable Long gunId) {
    gunsService.updatePartialGun(partialGunDTO, gunId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(path = "{gunId}")
  ResponseEntity<Void> deleteGun(@PathVariable Long gunId) {
    gunsService.deleteGunById(gunId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

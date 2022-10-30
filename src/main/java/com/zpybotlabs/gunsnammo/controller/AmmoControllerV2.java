package com.zpybotlabs.gunsnammo.controller;

import com.zpybotlabs.gunsnammo.dto.AmmoDTO;
import com.zpybotlabs.gunsnammo.service.AmmoService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v2/ammo")
@RestController
@Slf4j
@AllArgsConstructor
public class AmmoControllerV2 {

  private final AmmoService ammoService;

  @GetMapping
  ResponseEntity<List<AmmoDTO>> getAllAmmo() {
    return new ResponseEntity<>(ammoService.getAllAmmo(), HttpStatus.CREATED);
  }


  @PostMapping
  ResponseEntity<Void> addAmmo(@RequestBody List<AmmoDTO> ammo) {
    ammoService.createAmmo(ammo);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}

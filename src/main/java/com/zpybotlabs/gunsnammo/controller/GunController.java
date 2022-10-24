package com.zpybotlabs.gunsnammo.controller;

import com.zpybotlabs.gunsnammo.pojo.Gun;
import com.zpybotlabs.gunsnammo.service.GunService;
import java.util.List;
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

  @Autowired
  private GunService gunService;

  @GetMapping
  List<Gun> getGuns() {
    return gunService.getGuns();
  }

  @PostMapping
  void addGun(@RequestBody Gun gun) {
    System.out.println("POST request...");
    System.out.println(gun);
  }

  @DeleteMapping(path = "{gunId}")
  void deleteGun(@PathVariable Long gunId) {
    System.out.println("Delete request for gunId: " + gunId);
  }

  @PutMapping
  void updateGun(@RequestBody Gun gun) {
    System.out.println("Update request");
    System.out.println(gun);
  }
}

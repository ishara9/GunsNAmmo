package com.zpybotlabs.gunsnammo.service;

import com.zpybotlabs.gunsnammo.dao.GunRepo;
import com.zpybotlabs.gunsnammo.pojo.Gun;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GunService {

  @Autowired
//    @Qualifier("fake")
  private GunRepo gunRepo;

  public List<Gun> getGuns() {
    return gunRepo.getGuns();
  }

  public Gun getGun(Long gunId) {
    return gunRepo.getGuns().stream().filter(gun -> gun.getId().equals(gunId)).findFirst()
        .orElseThrow(() -> new IllegalArgumentException("gun not found with gunId: " + gunId));
  }
}

package com.zpybotlabs.gunsnammo.service;

import com.zpybotlabs.gunsnammo.dao.GunsRepository;
import com.zpybotlabs.gunsnammo.dto.PartialGunDTO;
import com.zpybotlabs.gunsnammo.exception.ServerRequestException;
import com.zpybotlabs.gunsnammo.pojo.Gun;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class GunsService {

  private final GunsRepository gunsRepository;

  public List<Gun> getGuns() {
    return gunsRepository.findAll();
  }

  public Gun getGun(Long gunId) {
    log.debug("Get gun by Id: " + gunId);
    return gunsRepository.findAll().stream().filter(gun -> gun.getId().equals(gunId)).findFirst()
        .orElseThrow(() -> {
          log.error("error when getting gun {}", gunId);
          return new ServerRequestException(
              "gun not found with gunId:" + gunId);
        });
  }

  public void createGuns(List<Gun> guns) {
    gunsRepository.saveAll(guns);
  }

  public void deleteGunById(Long gunId) {
    gunsRepository.deleteById(gunId);
  }

  @Transactional
  public void updateGun(Gun gun, Long gunId) {
    gunsRepository.findById(gunId)
        .ifPresent(value -> value.setName(gun.getName()).setEmail(gun.getEmail())
            .setSecurityKey(gun.getSecurityKey()));
  }

  @Transactional
  public void updatePartialGun(PartialGunDTO partialGunDTO, Long gunId) {
    gunsRepository.findById(gunId)
        .ifPresent(value -> value.setName(partialGunDTO.getName()));
  }
}

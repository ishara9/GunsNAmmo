package com.zpybotlabs.gunsnammo.service;

import com.zpybotlabs.gunsnammo.dao.GunsRepository;
import com.zpybotlabs.gunsnammo.exception.ServerRequestException;
import com.zpybotlabs.gunsnammo.pojo.Gun;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GunsService {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private GunsRepository gunsRepository;

  public List<Gun> getGuns() {
    return gunsRepository.findAll();
  }

  public Gun getGun(Long gunId) {
    LOGGER.debug("Get gun by Id: "+ gunId);
    return gunsRepository.findAll().stream().filter(gun -> gun.getId().equals(gunId)).findFirst()
        .orElseThrow(() -> new ServerRequestException("gun not found with gunId:" + gunId));
  }

  public void createGuns(List<Gun> guns) {
    gunsRepository.saveAll(guns);
  }
}

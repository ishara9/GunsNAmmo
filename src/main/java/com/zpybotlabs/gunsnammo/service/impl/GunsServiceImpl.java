package com.zpybotlabs.gunsnammo.service.impl;

import com.zpybotlabs.gunsnammo.dto.GunDTO;
import com.zpybotlabs.gunsnammo.exception.ServerRequestException;
import com.zpybotlabs.gunsnammo.model.Gun;
import com.zpybotlabs.gunsnammo.repository.GunsRepository;
import com.zpybotlabs.gunsnammo.service.GunsService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class GunsServiceImpl implements GunsService {

  private final GunsRepository gunsRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<GunDTO> getGuns() {
    return gunsRepository.findAll().stream().map(gun -> modelMapper.map(gun, GunDTO.class)).collect(
        Collectors.toList());
  }

  @Override
  public GunDTO getGun(Long gunId) {
    log.debug("Get gun by Id: " + gunId);
    return gunsRepository.findAll().stream().filter(gun -> gun.getGunId().equals(gunId))
        .map(gun -> modelMapper.map(gun, GunDTO.class))
        .findFirst()
        .orElseThrow(() -> {
          log.error("error when getting gun {}", gunId);
          return new ServerRequestException("gun not found with gunId:" + gunId);
        });
  }

  @Override
  public void createGuns(List<GunDTO> gunDTOs) {
    List<Gun> guns = modelMapper.map(gunDTOs, new TypeToken<List<Gun>>() {
    }.getType());
    gunsRepository.saveAll(guns);
  }

  @Override
  public void deleteGunById(Long gunId) {
    gunsRepository.deleteById(gunId);
  }

  @Override
  @Transactional
  public void updateGun(GunDTO gunDTO, Long gunId) {
    gunsRepository.findById(gunId)
        .ifPresent(value -> value.setName(gunDTO.getName()).setEmail(gunDTO.getEmail())
            .setSecurityKey(gunDTO.getSecurityKey()));
  }

  @Override
  @Transactional
  public void updatePartialGun(GunDTO gunDTO, Long gunId) {
    gunsRepository.findById(gunId)
        .ifPresent(value -> {
          Optional.ofNullable(gunDTO.getName()).map(value::setName);
          Optional.ofNullable(gunDTO.getEmail()).map(value::setEmail);
          Optional.ofNullable(gunDTO.getSecurityKey()).map(value::setSecurityKey);
        });
  }
}

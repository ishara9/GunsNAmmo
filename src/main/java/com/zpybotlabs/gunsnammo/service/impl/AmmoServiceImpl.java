package com.zpybotlabs.gunsnammo.service.impl;

import com.zpybotlabs.gunsnammo.dto.AmmoDTO;
import com.zpybotlabs.gunsnammo.model.Ammo;
import com.zpybotlabs.gunsnammo.model.Gun;
import com.zpybotlabs.gunsnammo.repository.AmmoRepository;
import com.zpybotlabs.gunsnammo.repository.GunsRepository;
import com.zpybotlabs.gunsnammo.service.AmmoService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AmmoServiceImpl implements AmmoService {

  private final AmmoRepository ammoRepository;
  private final GunsRepository gunsRepository;
  private final ModelMapper modelMapper;

  @Override
  public void createAmmo(List<AmmoDTO> ammoDTOs) {
    List<Ammo> ammo = modelMapper.map(ammoDTOs, new TypeToken<List<Ammo>>() {}.getType());
    ammoRepository.saveAll(ammo);
  }

  @Override
  public void createAmmo(AmmoDTO ammoDTOs) {
    Ammo ammo = modelMapper.map(ammoDTOs,Ammo.class);
    ammoRepository.save(ammo);
  }

  @Override
  public List<AmmoDTO> getAllAmmo() {
    List<Ammo> ammo = ammoRepository.findAll();
    if(!ammo.isEmpty())
    {
      return modelMapper.map(ammo,new TypeToken<List<AmmoDTO>>(){}.getType());
    }
    return Collections.EMPTY_LIST;
  }

  @Transactional
  @Override
  public void createAmmo(Long gunId, List<AmmoDTO> ammoDTOList) {

    Optional<Gun> gunById = gunsRepository.findById(gunId);
    if(gunById.isPresent())
    {
      List<Ammo> ammo = modelMapper.map(ammoDTOList, new TypeToken<List<Ammo>>() {
      }.getType());
      Gun gun = gunById.get();
      ammo.forEach(eachAmmo->eachAmmo.setGun(gun));
      ammoRepository.saveAll(ammo);
    }
  }
}

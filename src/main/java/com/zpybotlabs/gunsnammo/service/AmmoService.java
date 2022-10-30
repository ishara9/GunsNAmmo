package com.zpybotlabs.gunsnammo.service;

import com.zpybotlabs.gunsnammo.dto.AmmoDTO;
import java.util.List;

public interface AmmoService {

  /**
   * Add Bullets
   *
   * @param ammo
   */
  void createAmmo(List<AmmoDTO> ammo);

  void createAmmo(AmmoDTO ammoDTOs);

  List<AmmoDTO> getAllAmmo();
  void createAmmo(Long gunId, List<AmmoDTO> ammoDTOList);
}

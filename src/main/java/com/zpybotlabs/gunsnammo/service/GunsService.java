package com.zpybotlabs.gunsnammo.service;

import com.zpybotlabs.gunsnammo.dto.PartialGunDTO;
import com.zpybotlabs.gunsnammo.model.Gun;
import java.util.List;
import javax.transaction.Transactional;

public interface GunsService {

  /**
   * Get All guns
   * @return
   */
  List<Gun> getGuns();

  /**
   * Get a gun by Id
   * @param gunId
   * @return
   */
  Gun getGun(Long gunId);

  /**
   * Add new set of guns
   * @param guns
   */
  void createGuns(List<Gun> guns);

  /**
   * Delete a gun by Id
   * @param gunId
   */
  void deleteGunById(Long gunId);

  /**
   * Update a gun by Id
   * @param gun
   * @param gunId
   */
  @Transactional
  void updateGun(Gun gun, Long gunId);

  /**
   * Add a patch to a gun
   * @param partialGunDTO
   * @param gunId
   */
  @Transactional
  void updatePartialGun(PartialGunDTO partialGunDTO, Long gunId);
}

package com.zpybotlabs.gunsnammo.service;

import com.zpybotlabs.gunsnammo.dto.GunDTO;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;

public interface GunsService {

  /**
   * Get All guns
   *
   * @return
   */
  List<GunDTO> getGuns();

  /**
   * Get a gun by Id
   *
   * @param gunId
   * @return
   */
  GunDTO getGun(Long gunId);

  /**
   * Add new set of guns
   *
   * @param guns
   */
  void createGuns(List<GunDTO> guns);

  /**
   * Delete a gun by Id
   *
   * @param gunId
   */
  void deleteGunById(Long gunId);

  /**
   * Update a gun by Id
   *
   * @param gun
   * @param gunId
   */
  @Transactional
  void updateGun(GunDTO gun, Long gunId);

  /**
   * Add a patch to a gun
   *
   * @param gunDTO
   * @param gunId
   */
  @Transactional
  void updatePartialGun(GunDTO gunDTO, Long gunId);

  /**
   *
   * @param gunId
   * @param ammoDTOList
   */
  @Transactional
  void reload(Long gunId, List<UUID> ammoDTOList);
}

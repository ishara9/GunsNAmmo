package com.zpybotlabs.gunsnammo.repository;

import com.zpybotlabs.gunsnammo.model.Ammo;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmmoRepository extends JpaRepository<Ammo, UUID> {

  List<Ammo> findAllByIdIn(List<UUID> ids);

  List<Ammo> findAllByGun_gunId(Long gunId);
}

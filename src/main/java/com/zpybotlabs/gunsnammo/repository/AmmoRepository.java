package com.zpybotlabs.gunsnammo.repository;

import com.zpybotlabs.gunsnammo.model.Ammo;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmmoRepository extends JpaRepository<Ammo, UUID> {

}

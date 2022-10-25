package com.zpybotlabs.gunsnammo.repository;

import com.zpybotlabs.gunsnammo.model.Gun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GunsRepository extends JpaRepository<Gun, Long> {


}

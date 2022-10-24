package com.zpybotlabs.gunsnammo.dao;

import com.zpybotlabs.gunsnammo.pojo.Gun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GunsRepository extends JpaRepository<Gun, Long> {


}

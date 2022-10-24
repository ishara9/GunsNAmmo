package com.zpybotlabs.gunsnammo.dao;

import com.zpybotlabs.gunsnammo.pojo.Gun;
import java.util.Collections;
import java.util.List;

//@Repository //remove since in ServerConfig there is an @Bean for get GunRepo
public class GunRepository implements GunRepo {

  @Override
  public List<Gun> getGuns() {
    return Collections.singletonList(new Gun(1L, "T-56", "QWERTY"));
  }
}

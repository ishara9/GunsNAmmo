package com.zpybotlabs.gunsnammo.dao;

import com.zpybotlabs.gunsnammo.pojo.Gun;
import java.util.Arrays;
import java.util.List;

//@Repository(value = "fake")
public class GunFakeRepo implements GunRepo {

  @Override
  public List<Gun> getGuns() {
    return Arrays.asList(
        new Gun(1L, "Ak47", "QWERTY"),
        new Gun(2L, "M-16", "QWERTY")
    );
  }
}

package com.zpybotlabs.gunsnammo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Gun {

  Long id;
  String name;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  String securityKey;

  public Gun(long id, String name, String securityKey) {
    this.id = id;
    this.name = name;
    this.securityKey = securityKey;

  }

  @JsonProperty("gunId")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  public String getSecurityKey() {
    return securityKey;
  }

  public void setSecurityKey(String securityKey) {
    this.securityKey = securityKey;
  }

  @Override
  public String toString() {
    return "Gun{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", securityKey='" + securityKey + '\'' +
        '}';
  }
}

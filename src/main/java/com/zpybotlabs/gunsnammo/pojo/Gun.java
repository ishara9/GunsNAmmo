package com.zpybotlabs.gunsnammo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Gun {

  Long id;
  @NotBlank(message = "name must not be empty!")
  String name;

  @NotBlank(message = "email must be not empty!")
  @Email
  private final String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  String securityKey;

  public Gun(long id, String name, String email, String securityKey) {
    this.id = id;
    this.name = name;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "Gun{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", securityKey='" + securityKey + '\'' +
        '}';
  }
}

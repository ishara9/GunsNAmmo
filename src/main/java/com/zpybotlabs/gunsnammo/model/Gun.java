package com.zpybotlabs.gunsnammo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@ToString
public class Gun {

  @Id
  @GeneratedValue
  Long gunId;
  @NotBlank(message = "name must not be empty!")
  String name;

  @NotBlank(message = "email must be not empty!")
  @Email
  private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  String securityKey;

  @OneToMany(mappedBy = "gun")
  private Set<Ammo> ammoSet = new HashSet<>();

  public Gun() {
  }

  @JsonProperty("gunId")
  public Long getGunId() {
    return gunId;
  }

  public Gun setGunId(Long gunId) {
    this.gunId = gunId;
    return this;
  }

  public String getName() {
    return name;
  }

  public Gun setName(String name) {
    this.name = name;
    return this;
  }

  @JsonIgnore
  public String getSecurityKey() {
    return securityKey;
  }

  public Gun setSecurityKey(String securityKey) {
    this.securityKey = securityKey;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Gun setEmail(String email) {
    this.email = email;
    return this;
  }

  public Set<Ammo> getAmmoSet() {
    return ammoSet;
  }
}

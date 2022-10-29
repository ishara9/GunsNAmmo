package com.zpybotlabs.gunsnammo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zpybotlabs.gunsnammo.model.Ammo;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GunDTO {

  Long id;
  @NotBlank(message = "name must not be empty!")
  String name;

  @NotBlank(message = "email must be not empty!")
  @Email
  private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  String securityKey;

  private Set<Ammo> ammoSet;
}

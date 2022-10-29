package com.zpybotlabs.gunsnammo.dto;

import com.zpybotlabs.gunsnammo.model.Gun;
import java.util.UUID;
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
public class AmmoDTO {

  private UUID id;
  private String batch;
  private String bulletType;

}

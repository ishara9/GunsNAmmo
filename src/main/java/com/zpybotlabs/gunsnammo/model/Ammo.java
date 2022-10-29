package com.zpybotlabs.gunsnammo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zpybotlabs.gunsnammo.dto.BulletType;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Ammo {

  @Id
  private UUID id;
  private String batch;
  private BulletType bulletType;

  @ManyToOne
  @JoinColumn(name="gunId", nullable=true)
  private Gun gun;

}

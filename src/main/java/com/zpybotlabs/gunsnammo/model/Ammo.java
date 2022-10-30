package com.zpybotlabs.gunsnammo.model;

import com.zpybotlabs.gunsnammo.dto.BulletType;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

@Entity
@Table
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class Ammo {

  @Id
  @GeneratedValue
  @Column(unique = true)
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID id;
  private String batch;
  private BulletType bulletType;

  @ManyToOne
  @JoinColumn(name="gunId", nullable=true)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Gun gun;

}

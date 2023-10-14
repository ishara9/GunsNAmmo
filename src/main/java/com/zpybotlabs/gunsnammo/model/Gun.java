package com.zpybotlabs.gunsnammo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "GUN")
@AllArgsConstructor
@ToString
public class Gun {

    @Id
    Long id;
    @NotBlank(message = "name must not be empty!")
    String name;

    @NotBlank(message = "email must be not empty!")
    @Email
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Nullable
    @Transient
    String securityKey;

    public Gun() {
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public Gun setId(Long id) {
        this.id = id;
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
}

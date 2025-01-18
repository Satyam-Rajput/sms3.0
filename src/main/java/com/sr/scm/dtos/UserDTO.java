package com.sr.scm.dtos;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;

import java.util.List;

/**
 * The type User dto.
 */
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Boolean isLocked;
    private Boolean isExpired;
    private List<String> roles;

    /**
     * Instantiates a new User dto.
     */
    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public UserDTO setLocked(Boolean locked) {
        isLocked = locked;
        return this;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public UserDTO setExpired(Boolean expired) {
        isExpired = expired;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public UserDTO setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }
}

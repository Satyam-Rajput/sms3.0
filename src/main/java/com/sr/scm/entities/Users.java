package com.sr.scm.entities;

import com.sr.scm.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * The type Users.
 */
@Entity

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Boolean isLocked;
    private Boolean isExpired;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @return the id
     */
    public Users setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     * @return the username
     */
    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     * @return the password
     */
    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Gets locked.
     *
     * @return the locked
     */
    public Boolean getLocked() {
        return isLocked;
    }

    /**
     * Sets locked.
     *
     * @param locked the locked
     * @return the locked
     */
    public Users setLocked(Boolean locked) {
        isLocked = locked;
        return this;
    }

    /**
     * Gets expired.
     *
     * @return the expired
     */
    public Boolean getExpired() {
        return isExpired;
    }

    /**
     * Sets expired.
     *
     * @param expired the expired
     * @return the expired
     */
    public Users setExpired(Boolean expired) {
        isExpired = expired;
        return this;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     * @return the roles
     */
    public Users setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    /**
     * Instantiates a new Users.
     */
    public Users() {
    }


    /**
     * Parse dto from user user dto.
     *
     * @return the user dto
     */
    public static UserDTO parseDTOFromUser(Users user) {
        return new UserDTO().setExpired(user.isExpired)
                .setId(user.id)
                .setLocked(user.isLocked)
                .setUsername(user.getUsername())
                .setRoles(user.roles)
                .setPassword(user.getPassword());
    }


    /**
     * Parse user from dto users.
     *
     * @param userDTO the user dto
     * @return the users
     */
    public static Users parseUserFromDTO(UserDTO userDTO) {
        return new Users().setExpired(userDTO.getExpired())
                .setLocked(userDTO.getLocked())
                .setUsername(userDTO.getUsername())
                .setRoles(userDTO.getRoles())
                .setId(userDTO.getId())
                .setPassword(userDTO.getPassword());
    }
}

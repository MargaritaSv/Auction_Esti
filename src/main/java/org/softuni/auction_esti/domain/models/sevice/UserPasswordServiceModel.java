package org.softuni.auction_esti.domain.models.sevice;

import org.softuni.auction_esti.domain.entities.UserDetails;

public class UserPasswordServiceModel {

    private Integer id;
    private UserDetails userDetailsId;
    private String email;
    private String password;

    public UserPasswordServiceModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDetails getUserId() {
        return userDetailsId;
    }

    public void setUserId(UserDetails userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

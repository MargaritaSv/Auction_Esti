package org.softuni.auction_esti.domain.models.sevice;

import org.softuni.auction_esti.domain.entities.UserDetails;

public class UserPasswordServiceModel {

    private Integer id;
    private UserDetails userDetailsId;
    private String nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

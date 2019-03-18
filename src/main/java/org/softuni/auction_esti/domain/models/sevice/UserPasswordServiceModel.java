package org.softuni.auction_esti.domain.models.sevice;

import org.softuni.auction_esti.domain.entities.User;

public class UserPasswordServiceModel {

    private Integer id;
    private User userId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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

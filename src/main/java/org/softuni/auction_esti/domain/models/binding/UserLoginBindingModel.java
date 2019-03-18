package org.softuni.auction_esti.domain.models.binding;

public class UserLoginBindingModel {

    private String nickname;
    private String password;

    public UserLoginBindingModel() {
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

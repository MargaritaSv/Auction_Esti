package org.softuni.auction_esti.domain.models.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {

    private String nickname;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotNull
    @NotEmpty(message = "Name is required")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @NotNull
    @NotEmpty(message = "Password is required")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

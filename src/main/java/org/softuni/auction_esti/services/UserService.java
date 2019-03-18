package org.softuni.auction_esti.services;

import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;

public interface UserService {
    boolean createUser(UserRegisterBindingModel bindingModel);

}

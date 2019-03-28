package org.softuni.auction_esti.services;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.entities.Role;
import org.softuni.auction_esti.domain.entities.User;
import org.softuni.auction_esti.domain.entities.UserDetails;
import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;
import org.softuni.auction_esti.repository.UserPasswordRepository;
import org.softuni.auction_esti.repository.UserDetailsRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final ModelMapper modelMapper;
    private final UserPasswordRepository userPasswordRepository;
    private final Validator validator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserDetailsRepository userDetailsRepository, ModelMapper modelMapper, UserPasswordRepository userPasswordRepository, Validator validator, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.modelMapper = modelMapper;
        this.userPasswordRepository = userPasswordRepository;
        this.validator = validator;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /*
        If someone use register form can be only ordinary user
     */
    @Override
    public boolean createUser(UserRegisterBindingModel bindingModel) {

        // System.out.println(userPasswordRepository.findByEmail(bindingModel.getEmail()) == null);
        //(userPasswordRepository.findByEmail(bindingModel.getEmail()) != null) ||
        if (!(bindingModel.getPassword().equals(bindingModel.getPasswordConfirm()))) {
            return false;
        }

        UserDetails userDetails = this.modelMapper.map(bindingModel, UserDetails.class);
        User user_login = this.modelMapper.map(bindingModel, User.class);

        this.userDetailsRepository.save(userDetails);

        user_login.setUserId(userDetails);
        user_login.setPassword(this.bCryptPasswordEncoder.encode(bindingModel.getPassword()));
        user_login.setRoles(new LinkedHashSet<>(Role.ROLE_USER));

        this.userPasswordRepository.saveAndFlush(user_login);

        return true;
    }
    // )
//    @Override
//    public UserPasswordServiceModel logUser(String nickname) {
////        if (this.validator.validate()) {
////        }
//        return this.modelMapper.map(
//                this.userPasswordRepository.findByNickname(nickname), UserPasswordServiceModel.class);
//    }
}

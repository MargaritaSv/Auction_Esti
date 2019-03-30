package org.softuni.auction_esti.services;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.entities.Role;
import org.softuni.auction_esti.domain.entities.User;
import org.softuni.auction_esti.domain.entities.UserDetails;
import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;
import org.softuni.auction_esti.domain.models.sevice.UserPasswordServiceModel;
import org.softuni.auction_esti.repository.UserPasswordRepository;
import org.softuni.auction_esti.repository.UserDetailsRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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

        this.userDetailsRepository.saveAndFlush(userDetails);

        user_login.setUserId(userDetails);
        user_login.setPassword(this.bCryptPasswordEncoder.encode(bindingModel.getPassword()));


//role.setName(Role.ROLE_USER);
//role.setUsers(new LinkedList<>().add(user_login));
        this.userPasswordRepository.saveAndFlush(user_login);

//        List<User> users = new LinkedList<>();
//        users.add(user_login);
//
//        Role role = new Role(Role.ROLE_USER, users);
//
//        LinkedHashSet linkedHashSet = new LinkedHashSet();
//        linkedHashSet.add(role);
//        user_login.setRoles(linkedHashSet);

        return true;
    }

    // )
    @Override
    public UserPasswordServiceModel logUser(String email) {
//        if (this.validator.validate()) {
//        }
        return this.modelMapper.map(
                this.userPasswordRepository.findByEmail(email), UserPasswordServiceModel.class);
    }
}

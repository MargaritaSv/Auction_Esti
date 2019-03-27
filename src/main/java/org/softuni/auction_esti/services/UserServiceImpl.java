package org.softuni.auction_esti.services;

import org.modelmapper.ModelMapper;
import org.softuni.auction_esti.domain.entities.UserDetails;
import org.softuni.auction_esti.domain.models.binding.UserRegisterBindingModel;
import org.softuni.auction_esti.domain.models.sevice.UserPasswordServiceModel;
import org.softuni.auction_esti.repository.UserPasswordRepository;
import org.softuni.auction_esti.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final ModelMapper modelMapper;
    private final UserPasswordRepository userPasswordRepository;
    private final Validator validator;

    public UserServiceImpl(UserDetailsRepository userDetailsRepository, ModelMapper modelMapper, UserPasswordRepository userPasswordRepository, Validator validator) {
        this.userDetailsRepository = userDetailsRepository;
        this.modelMapper = modelMapper;
        this.userPasswordRepository = userPasswordRepository;
        this.validator = validator;
    }

//    @Override
//    public boolean createUser(UserRegisterBindingModel bindingModel) {
////TODO: check for exist nickname
//        //if exist email or password isn't eqaul
//        if ((userDetailsRepository.findUserByEmail(bindingModel.getEmail()) != null) ||
//                !(bindingModel.getPassword().equals(bindingModel.getPasswordConfirm()))) {
//            return false;
//        }
//
//        UserDetails userDetails = this.modelMapper.map(bindingModel, UserDetails.class);
//        this.userDetailsRepository.save(userDetails);
//
//        return true;
//    }

//    @Override
//    public UserPasswordServiceModel logUser(String nickname) {
////        if (this.validator.validate()) {
////        }
//        return this.modelMapper.map(
//                this.userPasswordRepository.findByNickname(nickname), UserPasswordServiceModel.class);
//    }
}

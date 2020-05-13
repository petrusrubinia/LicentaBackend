package com.backLicenta.user.service;

import com.backLicenta.user.domain.User;
import com.backLicenta.user.repository.IUserRepository;
import com.backLicenta.user.repository.IUserRepositoryCustom;
import com.backLicenta.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.backLicenta.user.validator.UserValidator;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final UserValidator userValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(final IUserRepository userRepository, final UserValidator userValidator){
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }
    public boolean login(User user) {
        System.out.println("aaaaaaaaaaaddddddddd");

        ValidationResult validationResult = new ValidationResult();
        userValidator.validateLogin(user,validationResult);
        return userRepository.login(user);
    }

    public User add(User user) {
        System.out.println("aaaaaaaaaaaddddddddd");
        ValidationResult validationResult = new ValidationResult();
        userValidator.validate(user,validationResult);
        user.setParola(bCryptPasswordEncoder.encode(user.getParola()));
        return userRepository.save(user);
    }

}

package com.backLicenta.user.service;

import com.backLicenta.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    User login(User user);

    User add(User user);

    Boolean saveChanges(User newUser);
}

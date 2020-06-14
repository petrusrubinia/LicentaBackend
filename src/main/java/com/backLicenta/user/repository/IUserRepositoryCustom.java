package com.backLicenta.user.repository;

import com.backLicenta.user.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositoryCustom {

    User login(User user, BCryptPasswordEncoder bCryptPasswordEncoder);
    boolean exist(User user);

    boolean update(User newUser);
}

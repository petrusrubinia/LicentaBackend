package com.backLicenta.user.repository;

import com.backLicenta.user.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositoryCustom {

    boolean login(User user);
}

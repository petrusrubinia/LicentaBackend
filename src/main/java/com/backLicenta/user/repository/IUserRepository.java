package com.backLicenta.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backLicenta.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer>, IUserRepositoryCustom {
}

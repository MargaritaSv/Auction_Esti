package org.softuni.auction_esti.repository;

import org.softuni.auction_esti.domain.entities.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPasswordRepository extends JpaRepository<UserPassword, Integer> {
    UserPassword findByNickname(String nickname);
}

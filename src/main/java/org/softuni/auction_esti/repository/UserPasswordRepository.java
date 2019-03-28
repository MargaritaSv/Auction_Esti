package org.softuni.auction_esti.repository;

import org.softuni.auction_esti.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPasswordRepository extends JpaRepository<User, Integer> {
    // User findByNickname(String nickname);
    Optional<User> findByEmail(String email);
}

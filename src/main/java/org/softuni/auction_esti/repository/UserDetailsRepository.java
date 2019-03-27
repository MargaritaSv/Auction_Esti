package org.softuni.auction_esti.repository;

import org.softuni.auction_esti.domain.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
   // UserDetails findUserByEmail(String email);
}

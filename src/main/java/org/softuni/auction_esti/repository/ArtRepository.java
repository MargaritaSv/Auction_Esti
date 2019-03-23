package org.softuni.auction_esti.repository;

import org.softuni.auction_esti.domain.entities.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository extends JpaRepository<Art, Integer> {
}

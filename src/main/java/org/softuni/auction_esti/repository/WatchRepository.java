package org.softuni.auction_esti.repository;

import org.softuni.auction_esti.domain.entities.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Integer> {
    //Watch findAllByCollection(String collection);

    Optional<Watch> findById(Integer id);
}

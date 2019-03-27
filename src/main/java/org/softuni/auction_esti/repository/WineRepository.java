package org.softuni.auction_esti.repository;

import org.softuni.auction_esti.domain.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer> {
}

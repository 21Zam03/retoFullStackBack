package com.zam.reto.repositories;

import com.zam.reto.entities.SoccerPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerPlayerRepository extends JpaRepository<SoccerPlayerEntity, Integer> {
}

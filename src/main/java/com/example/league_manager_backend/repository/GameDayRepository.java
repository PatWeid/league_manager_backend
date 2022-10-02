package com.example.league_manager_backend.repository;

import com.example.league_manager_backend.model.GameDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDayRepository extends JpaRepository<GameDay, Long> {
    GameDay findByNumber(int number);
}

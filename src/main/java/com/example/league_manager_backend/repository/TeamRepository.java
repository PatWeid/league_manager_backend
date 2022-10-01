package com.example.league_manager_backend.repository;

import com.example.league_manager_backend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Transactional
    void deleteById(long id);

    @Transactional
    void deleteByUserId(long userId);

    @Transactional
    Team findByUserId(long userId);
}

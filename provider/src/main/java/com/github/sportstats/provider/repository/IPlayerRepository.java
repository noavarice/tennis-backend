package com.github.sportstats.provider.repository;

import com.github.sportstats.provider.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<PlayerEntity, Integer> {}

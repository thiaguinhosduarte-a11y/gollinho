package com.empresa.gollinho.repository;

import com.empresa.gollinho.model.Fardo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FardoRepository extends JpaRepository<Fardo, Long> {
}
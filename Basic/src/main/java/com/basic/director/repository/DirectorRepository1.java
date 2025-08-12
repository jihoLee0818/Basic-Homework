package com.basic.director.repository;

import com.basic.director.entity.Director1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorRepository1 extends JpaRepository<Director1, Long> {
    Optional<Director1> findByName(String name);
}

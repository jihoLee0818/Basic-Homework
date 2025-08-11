package com.jpa.repository;


import com.jpa.entity.Movie1;
import com.jpa.entity.Review1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository1 extends JpaRepository<Review1, Long> {
    List<Review1> findAllByMovie(Movie1 movie);
}

package com.jpa.repository;

import com.jpa.entity.Movie2;
import com.jpa.entity.Review2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository2 extends JpaRepository<Review2, Long> {
    List<Review2> findAllByMovie(Movie2 movie);
}

package com.jpa.controller;

import com.jpa.dto.MovieRequest2;
import com.jpa.dto.MovieResponse2;
import com.jpa.service.MovieService;
import com.jpa.service.MovieService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController2 {

    private final MovieService2 movieService2;

    @PostMapping("/movies2")
    public ResponseEntity<MovieResponse2> saveMovie(
            @RequestBody MovieRequest2 request2
    ) {
        return ResponseEntity.ok(movieService2.save(request2));
    }

    @GetMapping("/movies2")
    public ResponseEntity<List<MovieResponse2>> getAllMovies(){return ResponseEntity.ok(movieService2.findAll());}

    @GetMapping("/movies2/{id}")
    public ResponseEntity<MovieResponse2> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(movieService2.findMovie(id));
    }

    @PutMapping("/movies2/{id}")
    public ResponseEntity<MovieResponse2> updateMovie(
            @PathVariable Long id,
            @RequestBody MovieRequest2 request2
    ) {
        return ResponseEntity.ok(movieService2.updateMovie(id, request2));
    }
}

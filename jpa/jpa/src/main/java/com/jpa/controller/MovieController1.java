package com.jpa.controller;

import com.jpa.dto.MovieRequest1;
import com.jpa.dto.MovieResponse1;
import com.jpa.service.MovieService1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController1 {

    private final MovieService1 movieService1;

    @PostMapping("/movies1")
    public ResponseEntity<MovieResponse1> saveMovie(
            @RequestBody MovieRequest1 request
    ) {
        return ResponseEntity.ok(movieService1.save(request));
    }

    @GetMapping("/movies1")
    public ResponseEntity<List<MovieResponse1>> getAllMovies(){return ResponseEntity.ok(movieService1.findAll());}

    @GetMapping("/movies1/{id}")
    public ResponseEntity<MovieResponse1> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(movieService1.findMovie(id));
    }

    @PutMapping("/movies1/{id}")
    public ResponseEntity<MovieResponse1> updateMovie(
            @PathVariable Long id,
            @RequestBody MovieRequest1 request
    ) {
        return ResponseEntity.ok(movieService1.updateMovie(id, request));
    }
}

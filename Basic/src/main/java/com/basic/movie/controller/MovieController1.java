package com.basic.movie.controller;

import com.basic.movie.dto.MovieRequest;
import com.basic.movie.dto.MovieResponse;
import com.basic.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController1 {

    private final MovieService movieService;

    @PostMapping("/directors/{directorId}/movies")
    public ResponseEntity<MovieResponse> create(
            @RequestBody MovieRequest request,
            @PathVariable Long directorId
    ) {
        return ResponseEntity.ok(movieService.save(request,directorId));
    }

    @GetMapping("/directors/{directorId}/movies")
    public ResponseEntity<List<MovieResponse>> getAll() {return ResponseEntity.ok(movieService.findAll());}
}

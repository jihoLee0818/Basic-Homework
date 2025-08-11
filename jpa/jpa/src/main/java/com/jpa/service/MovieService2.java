package com.jpa.service;

import com.jpa.dto.MovieRequest2;
import com.jpa.dto.MovieResponse2;
import com.jpa.entity.Movie2;
import com.jpa.repository.MovieRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService2 {

    private final MovieRepository2 movieRepository2;

    @Transactional
    public MovieResponse2 save(MovieRequest2 request2) {
        Movie2 movie = new Movie2(request2.getTitle());
        Movie2 savedMovie = movieRepository2.save(movie);
        return new MovieResponse2(
                savedMovie.getId(),
                savedMovie.getTitle()
        );
    }

    @Transactional(readOnly = true)
    public List<MovieResponse2> findAll() {
        List<Movie2> movies = movieRepository2.findAll();
        return movies.stream()
                .map(movie -> new MovieResponse2(
                        movie.getId(),
                        movie.getTitle()
                )).toList();
    }

    @Transactional
    public MovieResponse2 findMovie(Long id) {
        Movie2 movie = movieRepository2.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 영화가 없습니다."));
        return new MovieResponse2(movie.getId(), movie.getTitle());
    }

    @Transactional
    public MovieResponse2 updateMovie(Long id, MovieRequest2 request2) {
        Movie2 movie = movieRepository2.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 ID의 영화가 없습니다."));
        movie.update(request2.getTitle());

        return new MovieResponse2(movie.getId(), movie.getTitle());
    }
}

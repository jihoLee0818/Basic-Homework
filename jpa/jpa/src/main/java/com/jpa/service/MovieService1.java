package com.jpa.service;

import com.jpa.dto.MovieRequest1;
import com.jpa.dto.MovieResponse1;
import com.jpa.entity.Movie1;
import com.jpa.repository.MovieRepository1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService1 {

    private final MovieRepository1 movieRepository1;

    @Transactional
    public MovieResponse1 save(MovieRequest1 request) {
        Movie1 movie = new Movie1(request.getTitle());
        Movie1 savedMovie = movieRepository1.save(movie);
        return new MovieResponse1(
                savedMovie.getId(),
                savedMovie.getTitle()
        );
    }

    @Transactional(readOnly = true)
    public List<MovieResponse1> findAll() {
        List<Movie1> movies = movieRepository1.findAll();
        return movies.stream()
                .map(movie -> new MovieResponse1(
                        movie.getId(),
                        movie.getTitle()
                )).toList();
    }

    @Transactional(readOnly = true)
    public MovieResponse1 findMovie(Long id) {
        Movie1 movie = movieRepository1.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 영화가 없습니다."));
        return new MovieResponse1(movie.getId(), movie.getTitle());
    }

    @Transactional
    public MovieResponse1 updateMovie(Long id, MovieRequest1 request) {
        Movie1 movie = movieRepository1.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 영화가 없습니다."));
        movie.update(request.getTitle());

        return new MovieResponse1(movie.getId(), movie.getTitle());
    }
}

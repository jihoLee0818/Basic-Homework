package com.basic.movie.service;

import com.basic.director.entity.Director;
import com.basic.director.repository.DirectorRepository;
import com.basic.movie.dto.MovieRequest;
import com.basic.movie.dto.MovieResponse;
import com.basic.movie.entity.Movie;
import com.basic.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService1 {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    @Transactional
    public MovieResponse save(MovieRequest request, Long directorId) {
        Director director = directorRepository.findById(directorId).orElseThrow(
                () -> new IllegalArgumentException("없는 디렉터입니다.")
        );
        Movie movieToSave = new Movie(request.getTitle(), director);
        Movie savedMovie = movieRepository.save(movieToSave);
        return new MovieResponse(savedMovie.getId(), savedMovie.getTitle());
    }

    @Transactional(readOnly = true)
    public List<MovieResponse> findAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponse> dtos = new ArrayList<>();

        for (Movie movie : movies) {
            MovieResponse movieResponse = new MovieResponse(
                    movie.getId(),
                    movie.getTitle()
            );
            dtos.add(movieResponse);
        }
        return dtos;
    }
}

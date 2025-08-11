package com.jpa.service;

import com.jpa.dto.ReviewRequest1;
import com.jpa.dto.ReviewResponse1;
import com.jpa.entity.Movie1;
import com.jpa.entity.Review1;
import com.jpa.repository.MovieRepository1;
import com.jpa.repository.ReviewRepository1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService1 {

    private final ReviewRepository1 reviewRepository1;
    private final MovieRepository1 movieRepository1;

    @Transactional
    public ReviewResponse1 save(ReviewRequest1 request, Long movieId) {
        Movie1 movie = movieRepository1.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 없어요")
        );
        Review1 review = new Review1(
                request.getContent(),
                movie
        );
        Review1 savedReview = reviewRepository1.save(review);
        return new ReviewResponse1(
                savedReview.getId(),
                savedReview.getContent()
        );
    }

    @Transactional(readOnly = true)
    public List<ReviewResponse1> findAll(Long movieId) {
        Movie1 movie = movieRepository1.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 없어요")
        );

        List<Review1> reviews = reviewRepository1.findAllByMovie(movie);
        List<ReviewResponse1> dtos = new ArrayList<>();

        for (Review1 review : reviews) {
            dtos.add(
                    new ReviewResponse1(
                            review.getId(),
                            review.getContent()
                    )
            );
        }
        return dtos;
    }
}

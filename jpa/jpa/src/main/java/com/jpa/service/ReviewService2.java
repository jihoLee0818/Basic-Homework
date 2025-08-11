package com.jpa.service;

import com.jpa.dto.ReviewRequest2;
import com.jpa.dto.ReviewResponse2;
import com.jpa.entity.Movie2;
import com.jpa.entity.Review2;
import com.jpa.repository.MovieRepository2;
import com.jpa.repository.ReviewRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService2 {

    private final ReviewRepository2 reviewRepository2;
    private final MovieRepository2 movieRepository2;

    @Transactional
    public ReviewResponse2 save(ReviewRequest2 request2, Long movieId) {
        Movie2 movie = movieRepository2.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 없어요")
        );
        Review2 review = new Review2(
                request2.getContent(),
                movie
        );
        Review2 savedReview = reviewRepository2.save(review);
        return new ReviewResponse2(
                savedReview.getId(),
                savedReview.getContent()
        );
    }

    @Transactional(readOnly = true)
    public List<ReviewResponse2> findAll(Long movieId) {
        Movie2 movie = movieRepository2.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 없어요")
        );

        List<Review2> reviews = reviewRepository2.findAllByMovie(movie);
        List<ReviewResponse2> dtos = new ArrayList<>();

        for (Review2 review : reviews) {
            dtos.add(
                    new ReviewResponse2(
                            review.getId(),
                            review.getContent()
                    )
            );
        }
        return dtos;
    }
}

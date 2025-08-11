package com.jpa.controller;

import com.jpa.dto.ReviewResponse2;
import com.jpa.service.ReviewService2;
import com.jpa.dto.ReviewRequest2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController2 {

    private final ReviewService2 reviewService2;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<ReviewResponse2> saveReview(
            @RequestBody ReviewRequest2 request2,
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService2.save(request2,movieId));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<ReviewResponse2>> getAllReviews(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService2.findAll(movieId));
    }
}

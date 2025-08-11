package com.jpa.controller;

import com.jpa.dto.ReviewResponse1;
import com.jpa.service.ReviewService1;
import com.jpa.dto.ReviewRequest1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController1 {

    private final ReviewService1 reviewService;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<ReviewResponse1> saveReview(
            @RequestBody ReviewRequest1 request,
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService.save(request,movieId));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<ReviewResponse1>> getAllReviews(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService.findAll(movieId));
    }
}

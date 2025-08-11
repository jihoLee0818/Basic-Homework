package com.jpa.dto;


import lombok.Getter;

@Getter
public class ReviewResponse1 {

    private final Long id;
    private final String content;

    public ReviewResponse1(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}

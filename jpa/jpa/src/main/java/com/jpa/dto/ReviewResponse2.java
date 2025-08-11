package com.jpa.dto;

import lombok.Getter;

@Getter
public class ReviewResponse2 {

    private final Long id;
    private final String content;

    public ReviewResponse2(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}

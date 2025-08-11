package com.jpa.dto;

import lombok.Getter;

@Getter
public class MovieResponse2 {

    private final Long id;
    private final String title;

    public MovieResponse2(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}

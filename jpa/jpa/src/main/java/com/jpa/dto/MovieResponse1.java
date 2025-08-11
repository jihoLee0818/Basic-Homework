package com.jpa.dto;

import lombok.Getter;

@Getter
public class MovieResponse1 {

    private final Long id;
    private final String title;

    public MovieResponse1(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}

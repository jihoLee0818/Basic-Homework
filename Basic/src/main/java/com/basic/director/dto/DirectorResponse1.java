package com.basic.director.dto;

import lombok.Getter;

@Getter
public class DirectorResponse1 {

    private final Long id;
    private final String name;

    public DirectorResponse1(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

package com.basic.auth.dto;

import lombok.Getter;

@Getter
public class AuthResponse1 {

    private final Long id;

    public AuthResponse1(Long id) {this.id = id;}
}

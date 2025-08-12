package com.basic.auth.service;

import com.basic.auth.dto.AuthRequest;
import com.basic.auth.dto.AuthResponse;
import com.basic.director.entity.Director;
import com.basic.director.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService1 {

    private final DirectorRepository directorRepository;

    @Transactional
    public void signup(AuthRequest request1) {
        Director director = new Director(request1.getName());
        directorRepository.save(director);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(AuthRequest request) {
        Director director = directorRepository.findByName(request.getName()).orElseThrow(
                () -> new IllegalArgumentException("없는 감독입니다.")
        );
        return new AuthResponse(director.getId());
    }

}

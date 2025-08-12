package com.basic.director.service;

import com.basic.director.dto.DirectorResponse;
import com.basic.director.dto.DirectorResponse1;
import com.basic.director.entity.Director;
import com.basic.director.repository.DirectorRepository1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService1 {

    private final DirectorRepository1 directorRepository;

    @Transactional(readOnly = true)
    public List<DirectorResponse1> findAll() {
        List<Director> directors = directorRepository.findAll();
        List<DirectorResponse1> dtos = new ArrayList<>();
        for (Director director : directors) {
            DirectorResponse1 directorResponse = new DirectorResponse1(
                    director.getId(),
                    director.getName()
            );
            dtos.add(directorResponse);
        }
        return dtos;
    }
}

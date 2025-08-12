package com.basic.director.controller;

import com.basic.director.dto.DirectorResponse;
import com.basic.director.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DirectorController1 {

    private final DirectorService directorService;

    @GetMapping("/directors")
    public ResponseEntity<List<DirectorResponse>> getAll() {return ResponseEntity.ok(directorService.findAll());}
}

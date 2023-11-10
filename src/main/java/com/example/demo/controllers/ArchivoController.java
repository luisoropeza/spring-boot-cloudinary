package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.ArchivoModel;
import com.example.demo.services.ArchivoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/archivo")
@AllArgsConstructor
public class ArchivoController {
    private final ArchivoService archivoService;

    @GetMapping()
    public List<ArchivoModel> getAllArchivos() {
        return archivoService.getAllArchivos();
    }

    @PostMapping
    public ArchivoModel saveArchivo(@RequestParam("file") MultipartFile file) throws IOException {
        return archivoService.saveArchivo(file);
    }
}

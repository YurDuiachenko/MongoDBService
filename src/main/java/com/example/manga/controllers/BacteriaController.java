package com.example.manga.controllers;

import com.example.manga.models.Bacteria;
import com.example.manga.services.BacteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BacteriaController {

    @Autowired
    private BacteriaService bacteriaService;

    @GetMapping("/bacterias")
    Iterable<Bacteria> all() {
        return bacteriaService.getAllBacterias();
    }

    @PostMapping("/bacterias")
    Bacteria newBacteria(@RequestBody Bacteria newBacteria) {  
        return bacteriaService.createBacteria(newBacteria);
    }

    @PostMapping("/bacterias/updateBy")
    Bacteria updateBacteria(@RequestParam String id, @RequestBody Bacteria newBacteria) {
        return bacteriaService.updateBacteria(id, newBacteria);
    }

    @GetMapping("/bacterias/getBy")
    Optional<Bacteria> one(@RequestParam String id) throws Throwable {
        return Optional.ofNullable(bacteriaService.getBacteria(String.valueOf(id)));
//        return (StudentDto) studentService.findStudent(id)
//                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/bacterias/deleteBy")
    void deleteBacteria(@RequestParam String id) {
        bacteriaService.deleteBacteria(String.valueOf(id));
    }

    @DeleteMapping("/bacterias")
    void deleteAll() {
        bacteriaService.deleteAllBacterias();
    }
}
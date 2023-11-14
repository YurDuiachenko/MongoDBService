package com.example.manga.controllers;

import com.example.manga.models.Fungi;
import com.example.manga.services.FungiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FungiController {

    @Autowired
    private FungiService fungiService;

    @GetMapping("/fungis")
    Iterable<Fungi> all() {
        return fungiService.getAllFungis();
    }

    @PostMapping("/fungis")
    Fungi newFungi(@RequestBody Fungi newFungi) {
        return fungiService.createFungi(newFungi);
    }

//    @PostMapping("/fungis/updateBy")
//    Fungi updateFungi(@RequestParam String id, @RequestBody Fungi newFungi) {
//        return fungiService.updateFungi(id, newFungi);
//    }

    @GetMapping("/fungis/getBy")
    Optional<Fungi> one(@RequestParam String id) throws Throwable {
        return Optional.ofNullable(fungiService.getFungi(String.valueOf(id)));
        //        return (StudentDto) studentService.findStudent(id)
        //                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/fungis/deleteBy")
    void deleteFungi(@RequestParam String id) {
        fungiService.deleteFungi(String.valueOf(id));
    }

    @DeleteMapping("/fungis")
    void deleteAll() {
        fungiService.deleteAllFungis();
    }
}

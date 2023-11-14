package com.example.manga.init;

import com.example.manga.models.Bacteria;
import com.example.manga.services.BacteriaService;
import com.example.manga.services.FungiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomCode implements CommandLineRunner {
    @Autowired
    private BacteriaService bacteriaService;
    @Autowired
    private FungiService fungiService;

    @Override
    public void run(String... args) throws Exception {
        List<Bacteria> storedBacteria = bacteriaService.getAllBacterias();
        List<Bacteria> t = bacteriaService.findCiliaBetween(0, 1);
        fungiService.deleteAllFungis();
        for (Bacteria b : storedBacteria) {
            System.out.println(b);
//            System.out.print(" - ");
        }
        System.out.println();
        for (Bacteria b : t) {
            System.out.println(b);
//            System.out.print(" - ");
        }
        System.out.println(fungiService.getAllFungis());
        bacteriaService.deleteAllBacterias();
    }
}


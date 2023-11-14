package com.example.manga.init;

import com.example.manga.models.Bacteria;
import com.example.manga.models.BacteriaFactory;
import com.example.manga.models.Fungi;
import com.example.manga.services.BacteriaService;
import com.example.manga.services.FungiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {
    @Autowired
    private BacteriaService bacteriaServices;
    @Autowired
    private FungiService fungiServices;
    @Autowired
    private BacteriaFactory bacteriaFactory;
    @Override
    public void run(String... args) throws Exception {
        bacteriaServices.deleteAllBacterias();
        List<Bacteria> books = bacteriaFactory.listBuilder().bacterias(2, 2);
        books = bacteriaServices.saveAllBacterias(books);

        Fungi fungis = new Fungi("Belii", true , "Colorado", "Flu", books);
        System.out.println(fungiServices.createFungi(fungis));
        System.out.println(222);
    }
}

package com.example.manga.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BacteriaFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);

    private final Faker faker = new Faker();
    public String name() { return faker.name().fullName(); }
    public int flagella() {return faker.number().numberBetween(0, 6);}
    public int cilia() {return faker.number().numberBetween(0, 6);}
    public String symtoms() { return faker.medical().diseaseName(); }

    public Bacteria make(UnaryOperator<Bacteria>...bacterias) {
        final Bacteria result = new Bacteria(
                name(),
                flagella(),
                cilia(),
                symtoms()
        );
        Stream.of(bacterias).forEach(v->v.apply(result));
        return result;
    }

    public static UnaryOperator<Bacteria> oneUpId = s->{

        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public BooksListDTOFactory listBuilder() {
        return new
            BooksListDTOFactory();
    }

    public class BooksListDTOFactory {
        public List<Bacteria> bacterias(int min, int max, UnaryOperator<Bacteria>...bacterias) {

            return IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i-> BacteriaFactory.this.make(bacterias))
                    .collect(Collectors.toList());
        }
    }
}
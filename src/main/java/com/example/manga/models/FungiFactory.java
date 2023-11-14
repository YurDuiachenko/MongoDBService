package com.example.manga.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FungiFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);

    private final Faker faker = new Faker();
    public String name() { return faker.name().fullName(); }
    public boolean venom() {return faker.bool().bool();}
    public String area() {return faker.address().country();}
    public String symtoms() { return faker.medical().diseaseName(); }

    public Fungi make(UnaryOperator<Fungi>...fungis) {
        final Fungi result = new Fungi(
            name(),
            venom(),
            area(),
            symtoms()
        );
        Stream.of(fungis).forEach(v->v.apply(result));
        return result;
    }

    public static UnaryOperator<Fungi> oneUpId = s->{

        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public BooksListDTOFactory listBuilder() {
        return new
            BooksListDTOFactory();
    }

    public class BooksListDTOFactory {
        public List<Fungi> fungis(int min, int max, UnaryOperator<Fungi>...fungis) {

            return IntStream.range(0, faker.number().numberBetween(min, max))
                .mapToObj(i-> FungiFactory.this.make(fungis))
                .collect(Collectors.toList());
        }
    }
}
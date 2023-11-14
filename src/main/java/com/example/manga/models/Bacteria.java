package com.example.manga.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "bacterias")
public class Bacteria {
    @Id
//    @Indexed(unique = true, sparse = true, direction =
//            IndexDirection.ASCENDING, background = false)
    private String id;
    @Field(name="name")
    private String name;
    @Field(name="flagella")
    private int flagella;
    @Field(name="cilia")
    private int cilia;
    @Field(name="symtoms")
    private String symtoms;

    public Bacteria(String id, String name, int flagella, int cilia, String symtoms) {
        this.id = id;
        this.name = name;
        this.flagella = flagella;
        this.cilia = cilia;
        this.symtoms = symtoms;
    }

    public Bacteria(String name, int flagella, int cilia, String symtoms) {
        this.name = name;
        this.flagella = flagella;
        this.cilia = cilia;
        this.symtoms = symtoms;
    }

    public Bacteria() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagella() {
        return flagella;
    }

    public void setFlagella(int flagella) {
        this.flagella = flagella;
    }

    public int getCilia() {
        return cilia;
    }

    public void setCilia(int cilia) {
        this.cilia = cilia;
    }

    public String getSymtoms() {
        return symtoms;
    }

    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }

    @Override
    public String toString() {
        return "Bacteria{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flagella=" + flagella +
                ", cilia=" + cilia +
                ", symtoms='" + symtoms + '\'' +
                '}';
    }
}

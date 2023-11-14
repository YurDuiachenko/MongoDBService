package com.example.manga.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Set;

@Document(collection = "fungi")
public class Fungi {
    @Id
    //    @Indexed(unique = true, sparse = true, direction =
    //            IndexDirection.ASCENDING, background = false)
    private String id;
    @Field(name="name")
    private String name;
    @Field(name="venom")
    private boolean venom;
    @Field(name="area")
    private String area;
    @Field(name="symtoms")
    private String symtoms;

    @Field(name = "bacterias")
    List<Bacteria> bacterias;

    public Fungi() {
    }

    public Fungi(String id, String name, boolean venom, String area, String symtoms) {
        this.id = id;
        this.name = name;
        this.venom = venom;
        this.area = area;
        this.symtoms = symtoms;
    }

    public Fungi(String name, boolean venom, String area, String symtoms) {
        this.name = name;
        this.venom = venom;
        this.area = area;
        this.symtoms = symtoms;
    }

    public Fungi( String name, boolean venom, String area, String symtoms, List<Bacteria> bacterias) {
        this.id = id;
        this.name = name;
        this.venom = venom;
        this.area = area;
        this.symtoms = symtoms;
        this.bacterias = bacterias;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public void setBacterias(List<Bacteria> bacterias) {
        this.bacterias = bacterias;
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

    public boolean isVenom() {
        return venom;
    }

    public void setVenom(boolean venom) {
        this.venom = venom;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSymtoms() {
        return symtoms;
    }

    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }

    @Override
    public String toString() {
        return "Fungi{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", venom=" + venom +
            ", area='" + area + '\'' +
            ", symtoms='" + symtoms + '\'' +
            ", bacterias=" + bacterias +
            '}';
    }
}


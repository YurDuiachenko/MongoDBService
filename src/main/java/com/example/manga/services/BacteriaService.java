package com.example.manga.services;

import com.example.manga.models.Bacteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BacteriaService {

        Bacteria createBacteria(Bacteria bacteria);
        Bacteria updateBacteria(String id, Bacteria bacteria);
        Optional<Bacteria> findById(String id);
        Bacteria getBacteria(String id);
        void deleteBacteria(String id);
        void deleteAllBacterias();
        List<Bacteria> saveAllBacterias(List<Bacteria> bacterias);
        Page<Bacteria> getBacterias(Pageable pageable);
        List<Bacteria> getAllBacterias();
        Page<Bacteria> findFlagellaAfter(int flagella, Pageable pageable);
        List<Bacteria> findCiliaBetween(int starting, int ending);



}

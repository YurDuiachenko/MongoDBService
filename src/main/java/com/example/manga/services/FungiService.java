package com.example.manga.services;

import com.example.manga.models.Fungi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * todo Document type FungiService
 */
public interface FungiService {

    Fungi createFungi(Fungi fungi);

    Optional<Fungi> findById(String id);
    Fungi getFungi(String id);
    void deleteFungi(String id);
    void deleteAllFungis();
    void saveAllFungis(List<Fungi> fungis);
    Page<Fungi> getFungis(Pageable pageable);
    List<Fungi> getAllFungis();


}

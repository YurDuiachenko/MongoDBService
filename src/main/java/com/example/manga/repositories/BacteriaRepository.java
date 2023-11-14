package com.example.manga.repositories;

import com.example.manga.models.Bacteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BacteriaRepository extends MongoRepository<Bacteria, String> {

    //Name queries
    Optional<Bacteria> getByName(String name);
    List<Bacteria> findByName(String name);
    List<Bacteria> findByNameNot(String name);
    List<Bacteria> findByNameContaining(String name);
    List<Bacteria> findByNameNotContaining(String name);

    //Cilia queries
    Optional<Bacteria> getByCilia(int cilia);
    List<Bacteria> findByCilia(int cilia);
    List<Bacteria> findByCiliaGreaterThanEqual(int cilia);
    @Query("{ 'cilia': { $gte: ?0, $lte: ?1 } }")
    List<Bacteria> findByCiliaBetween(int starting, int ending);

    //Flagella queries
    Optional<Bacteria> getByFlagella(int flagella);
    List<Bacteria> findByFlagella(int flagella);
    Page<Bacteria> findByFlagellaAfter(int flagella, Pageable pageable);

    //Symtoms queries
    Optional<Bacteria> getBySymtoms(String symtoms);
    List<Bacteria> findBySymtoms(String symtoms);

    //Special queries
    List<Bacteria> findByNameAndCilia(String name, int cilia);
    Slice<Bacteria> findByNameAndCilia(String name, int cilia, Pageable pageable);
    Page<Bacteria> findPageByNameAndCilia(String name, int cilia, Pageable pageable);

    Slice<Bacteria> findByNameStartingWith(String string, Pageable pageable);
    Page<Bacteria> findPageByNameStartingWith(String string, Pageable pageable);


}

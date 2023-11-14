package com.example.manga.repositories;

import com.example.manga.models.Bacteria;
import com.example.manga.models.Fungi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FungiRepository extends MongoRepository<Fungi, String> {

}

package com.example.manga.services.Impl;

import com.example.manga.errors.ClientErrorException;
import com.example.manga.models.Fungi;
import com.example.manga.repositories.BacteriaRepository;
import com.example.manga.repositories.FungiRepository;
import com.example.manga.services.BacteriaService;
import com.example.manga.services.FungiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FungiServiceImpl implements FungiService {

    private final FungiRepository fungiRepo;

    @Autowired
    private final BacteriaService bacteriaService;
    private final BacteriaRepository bacteriaRepo;

    public FungiServiceImpl(FungiRepository fungiRepo, BacteriaService bacteriaService, BacteriaRepository bacteriaRepo) {
        this.fungiRepo = fungiRepo;
        this.bacteriaService = bacteriaService;
        this.bacteriaRepo = bacteriaRepo;
    }

    @Override
    public Fungi createFungi(Fungi fungi) {

        fungiRepo.save(fungi);
        return fungi;
    }


    @Override
    public Optional<Fungi> findById(String id) {
        return fungiRepo.findById(id);
    }

    @Override
    public Fungi getFungi(String id) {
        return fungiRepo.findById(id)
            .orElseThrow(()->new
                ClientErrorException.NotFoundException("Бактерия с id=[%s] не найдена", id));
    }

    @Override
    public void deleteFungi(String id) {
        Fungi fungi = getFungi(id);
        System.out.println(fungi.getBacterias());
        for(var b: fungi.getBacterias()){
            bacteriaService.deleteBacteria(b.getId());
//            bacteriaRepo.delete(b);
//            bacteriaRepo.deleteById(b.getId());
        }
        fungiRepo.deleteById(id);
    }

    @Override
    public void deleteAllFungis() {
        fungiRepo.deleteAll();
    }

    @Override
    public void saveAllFungis(List<Fungi> fungis) {
        fungiRepo.saveAll(fungis);
    }

    @Override
    public Page<Fungi> getFungis(Pageable pageable) {
        Page<Fungi> fungis = fungiRepo.findAll(pageable);
        return fungis;
    }

    @Override
    public List<Fungi> getAllFungis() {
        return fungiRepo.findAll();
    }


}

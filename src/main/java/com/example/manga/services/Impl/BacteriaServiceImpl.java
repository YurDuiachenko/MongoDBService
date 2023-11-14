package com.example.manga.services.Impl;

import com.example.manga.errors.ClientErrorException;
import com.example.manga.models.Bacteria;
import com.example.manga.repositories.BacteriaRepository;
import com.example.manga.services.BacteriaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BacteriaServiceImpl implements BacteriaService {

    private final BacteriaRepository bacteriaRepo;

    public BacteriaServiceImpl(BacteriaRepository bacteriasRepo) {
                this.bacteriaRepo = bacteriasRepo;
    }

    @Override
    public Bacteria createBacteria(Bacteria bacteria) {
        bacteriaRepo.save(bacteria);
        return bacteria;
    }

    @Override
    public Bacteria updateBacteria(String id, Bacteria bacteria) {
        Optional<Bacteria> b =  bacteriaRepo.findById(id);
        b.get().setFlagella(bacteria.getFlagella());
        b.get().setCilia(bacteria.getCilia());
        b.get().setName(bacteria.getName());
        b.get().setSymtoms(bacteria.getSymtoms());
        return bacteriaRepo.save(b.get());
    }

    @Override
    public Optional<Bacteria> findById(String id) {
        return bacteriaRepo.findById(id);
    }

    @Override
    public Bacteria getBacteria(String id) {
        return bacteriaRepo.findById(id)
                .orElseThrow(()->new
                        ClientErrorException.NotFoundException("Бактерия с id=[%s] не найдена", id));
    }

    @Override
    public void deleteBacteria(String id) {
        bacteriaRepo.deleteById(id);
    }

    @Override
    public void deleteAllBacterias() {
        bacteriaRepo.deleteAll();
    }

    @Override
    public List<Bacteria> saveAllBacterias(List<Bacteria> bacterias) {
        return bacteriaRepo.saveAll(bacterias);
    }

    @Override
    public Page<Bacteria> getBacterias(Pageable pageable) {
        Page<Bacteria> bacterias = bacteriaRepo.findAll(pageable);
        return bacterias;
    }

    @Override
    public List<Bacteria> getAllBacterias() {
            return bacteriaRepo.findAll();
    }

    @Override
    public Page<Bacteria> findFlagellaAfter(int flagella, Pageable pageable) {
        Page<Bacteria> bacterias = bacteriaRepo.findByFlagellaAfter(flagella, pageable);
        return bacterias;
    }

    @Override
    public List<Bacteria> findCiliaBetween(int starting, int ending) {
        return bacteriaRepo.findByCiliaBetween(starting, ending);
    }

}
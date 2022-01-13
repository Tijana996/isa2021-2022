package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Vikendica;
import com.ftn.ISA2122.repository.VikendicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VikendicaService implements ServiceInterface<Vikendica> {
    @Autowired
    VikendicaRepository vikendicaRepository;

    @Override
    public List<Vikendica> findAll() {
        return vikendicaRepository.findAll();
    }

    @Override
    public Vikendica findOne(Long id) {
        return vikendicaRepository.findById(id).orElse(null);
    }

    @Override
    public Vikendica create(Vikendica entity) throws Exception {
        return null;
    }

    @Override
    public Vikendica update(Vikendica entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}

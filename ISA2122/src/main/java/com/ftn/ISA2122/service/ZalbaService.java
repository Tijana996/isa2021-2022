package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Zalba;
import com.ftn.ISA2122.repository.ZalbaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZalbaService implements ServiceInterface<Zalba>{

    @Autowired
    private ZalbaRepository zalbaRepository;

    @Override
    public List<Zalba> findAll() {
        return zalbaRepository.findAll();
    }

    public List<Zalba> findAllNeresene() {
        return zalbaRepository.findAllByResenaIsFalse();
    }

    @Override
    public Zalba findOne(Long id) {
        return zalbaRepository.findById(id).orElseGet(null);
    }

    @Override
    public Zalba create(Zalba entity) throws Exception {
        return zalbaRepository.save(entity);
    }

    @Override
    public Zalba update(Zalba entity, Long id) throws Exception {
        Zalba zalba = findOne(id);

        zalba.setOdgovor(entity.getOdgovor());
        zalba.setResena(true);

        return zalbaRepository.save(zalba);
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}

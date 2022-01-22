package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Admin;
import com.ftn.ISA2122.model.Vikendica;
import com.ftn.ISA2122.model.VlasnikVikendice;
import com.ftn.ISA2122.repository.VlasnikVikendiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VlasnikVikendiceService implements ServiceInterface<VlasnikVikendice>{

    @Autowired
    private VlasnikVikendiceRepository vlasnikVikendiceRepository;

    @Override
    public List<VlasnikVikendice> findAll() {
        return null;
    }

    @Override
    public VlasnikVikendice findOne(Long id) {
        return null;
    }

    public VlasnikVikendice findOneByVikendica(Vikendica vikendica) {
        return vlasnikVikendiceRepository.findByVikendiceContains(vikendica);
    }

    @Override
    public VlasnikVikendice create(VlasnikVikendice entity) throws Exception {
        return null;
    }

    @Override
    public VlasnikVikendice update(VlasnikVikendice entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}

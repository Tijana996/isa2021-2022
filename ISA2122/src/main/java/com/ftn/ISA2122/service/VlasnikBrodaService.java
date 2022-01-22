package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Brod;
import com.ftn.ISA2122.model.VlasnikBroda;
import com.ftn.ISA2122.repository.VlasnikBrodaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VlasnikBrodaService implements ServiceInterface<VlasnikBroda>{

    @Autowired
    private VlasnikBrodaRepository vlasnikBrodaRepository;

    @Override
    public List<VlasnikBroda> findAll() {
        return null;
    }

    @Override
    public VlasnikBroda findOne(Long id) {
        return null;
    }

    public VlasnikBroda findOneByBrod(Brod brod) {
        return vlasnikBrodaRepository.findByBrodoviContains(brod);
    }

    @Override
    public VlasnikBroda create(VlasnikBroda entity) throws Exception {
        return null;
    }

    @Override
    public VlasnikBroda update(VlasnikBroda entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}

package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.ZahteviZaBrisanje;
import com.ftn.ISA2122.repository.ZahteviZaBrisanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZavteviZaBrisanjeService implements ServiceInterface<ZahteviZaBrisanje> {

    @Autowired
    private ZahteviZaBrisanjeRepository zahteviZaBrisanjeRepository;

    @Override
    public List<ZahteviZaBrisanje> findAll() {
        return zahteviZaBrisanjeRepository.findAll();
    }

    @Override
    public ZahteviZaBrisanje findOne(Long id) {
        return zahteviZaBrisanjeRepository.findById(id).orElse(null);
    }

    @Override
    public ZahteviZaBrisanje create(ZahteviZaBrisanje entity) throws Exception {
        return zahteviZaBrisanjeRepository.save(entity);
    }

    @Override
    public ZahteviZaBrisanje update(ZahteviZaBrisanje entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        zahteviZaBrisanjeRepository.deleteById(id);
    }
}

package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.ZahtevZaRegistraciju;
import com.ftn.ISA2122.repository.ZahtevZaRegistracijuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahtevZaRegistracijuService implements ServiceInterface<ZahtevZaRegistraciju>{

    @Autowired
    private ZahtevZaRegistracijuRepository repository;

    @Override
    public List<ZahtevZaRegistraciju> findAll() {
        return repository.findAll();
    }

    @Override
    public ZahtevZaRegistraciju findOne(Long id) {
        return repository.getById(id);
    }

    @Override
    public ZahtevZaRegistraciju create(ZahtevZaRegistraciju entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    public ZahtevZaRegistraciju update(ZahtevZaRegistraciju entity, Long id) throws Exception {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) throws Exception {
        repository.deleteById(id);
    }
}

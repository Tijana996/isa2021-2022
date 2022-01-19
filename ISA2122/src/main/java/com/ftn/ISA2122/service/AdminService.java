package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Admin;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements ServiceInterface<Admin>{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Admin findOne(Long id) {
        return adminRepository.findById(id).orElseGet(null);
    }

    @Override
    public Admin create(Admin entity) throws Exception {
        return null;
    }

    @Override
    public Admin update(Admin entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}

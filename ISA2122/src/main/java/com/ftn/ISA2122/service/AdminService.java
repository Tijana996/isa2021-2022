package com.ftn.ISA2122.service;

import com.ftn.ISA2122.model.Admin;
import com.ftn.ISA2122.model.Korisnik;
import com.ftn.ISA2122.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements ServiceInterface<Admin>{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        Admin user = adminRepository.findById(id).orElse(null);
        if(user == null) throw new Exception("User with given id doesn't exist");

        if(!user.getEmail().equals(entity.getEmail())) throw new Exception("Email can't be changed");

        if(!user.getPassword().equals(passwordEncoder.encode(entity.getPassword())) && !user.getPassword().equals(entity.getPassword())) {
            user.setLozinka(passwordEncoder.encode(entity.getPassword()));
            user.setMenjanjeLozinke(false);
        }
        return adminRepository.save(user);
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}

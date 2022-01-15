package com.ftn.ISA2122.service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import com.ftn.ISA2122.model.*;
import com.ftn.ISA2122.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService implements ServiceInterface<Korisnik> {
	
	@Autowired
	private KorisnikRepository repository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private InstruktorPecanjaRepository instruktorPecanjaRepository;

	@Autowired
	private VlasnikBrodaRepository vlasnikBrodaRepository;

	@Autowired
	private VlasnikVikendiceRepository vlasnikVikendiceRepository;

	@Autowired
	private KlijentRepository klijentRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Korisnik> findAll() {
		return repository.findAll();
	}

	@Override
	public Korisnik findOne(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Korisnik create(Korisnik entity) throws Exception {
		return null;
	}

//	@Override
//	public Korisnik create(Korisnik entity) {
//		Korisnik existUserMail = repository.findByEmail(entity.getEmail());
//		Korisnik user = null;
//		try{
//			if (existUserMail != null) {
//				throw new Exception("Email already exists");
//			}
//			entity.setLozinka(passwordEncoder.encode(entity.getLozinka()));
//			//entity.setEnabled(true);
//			user = repository.save(entity);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		return user;
//	}

	public Korisnik createKorisnik(Korisnik entity, TipKorisnika tip) throws Exception {
		Korisnik existUser = repository.findByEmail(entity.getEmail());
		if (existUser != null) {
			throw new Exception("Email already exists");
		}

		entity.setLozinka(passwordEncoder.encode(entity.getLozinka()));
		if (tip.equals(TipKorisnika.KLIJENT)){
			Authority authority =  authorityRepository.findByName("ROLE_KLIJENT");
			setAuths(authority, entity);
			klijentRepository.save((Klijent) entity);
		}
		else if (tip.equals(TipKorisnika.INSTRUKTOR)){
			Authority authority =  authorityRepository.findByName("ROLE_INSTRUKTOR");
			List<Authority> authorities = new ArrayList<>();
			setAuths(authority, entity);

			InstruktorPecanja instruktorPecanja = (InstruktorPecanja) entity;
			instruktorPecanja.setLokacija("lokacija");
			instruktorPecanja.setOcena(0);

			instruktorPecanjaRepository.save(instruktorPecanja);
		}
		else if (tip.equals(TipKorisnika.VLASNIKBRODA)){
			Authority authority =  authorityRepository.findByName("ROLE_BROD");
			setAuths(authority, entity);

			VlasnikBroda vlasnikBroda = (VlasnikBroda) entity;
			vlasnikBroda.setBrodovi(new HashSet<>());
			vlasnikBrodaRepository.save(vlasnikBroda);
		}
		else if (tip.equals(TipKorisnika.VLASNIKVIKENDICE)){
			Authority authority =  authorityRepository.findByName("ROLE_VIKENDICA");
			setAuths(authority, entity);

			VlasnikVikendice vlasnikVikendice = (VlasnikVikendice) entity;
			vlasnikVikendice.setVikendice(new HashSet<>());
			vlasnikVikendiceRepository.save(vlasnikVikendice);
		}
		else {
			Authority authority =  authorityRepository.findByName("ROLE_ADMIN");
			setAuths(authority, entity);

			Admin admin = (Admin) entity;
			admin.setPredefinisan(false);
			admin.setMenjanjeLozinke(true);
			adminRepository.save(admin);
		}

		return entity;
	}

	private void setAuths(Authority authority, Korisnik entity){
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authority);
		entity.setAuthorities(authorities);
	}

	@Override
	public Korisnik update(Korisnik entity, Long id) throws Exception{
		Korisnik user = repository.findById(id).orElse(null);
		if(user == null) throw new Exception("User with given id doesn't exist");

		if(!user.getEmail().equals(entity.getEmail())) throw new Exception("Email can't be changed");

		if(!user.getPassword().equals(passwordEncoder.encode(entity.getPassword())) && !user.getPassword().equals(entity.getPassword())) {
			user.setLozinka(passwordEncoder.encode(entity.getPassword()));
		}
		return repository.save(user);
	}

	@Override
	public void delete(Long id) throws Exception {
		try{
			Korisnik user = repository.findById(id).orElse(null);
			//TODO provera dal ima pregleda ili sta vec pise u specifikaciji
			repository.deleteById(id);

		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("User with given id doesn't exist");
		}
		
	}

	public void createRegistrationVerificationToken(Korisnik user, String token) {
		Korisnik registeredUser = repository.findById(user.getId()).orElseGet(null);
		VerificationToken verificationToken = new VerificationToken(token, registeredUser, VerificationTokenType.REGISTRATION);

		verificationToken = verificationTokenRepository.save(verificationToken);
		registeredUser.setToken(verificationToken);
		repository.save(registeredUser);
	}

	public void verifyRegistrationToken(String token) throws Exception {
		VerificationToken verificationToken =
				verificationTokenRepository.findByTokenAndType(token, VerificationTokenType.REGISTRATION);

		if (verificationToken == null) {
			throw new Exception("Invalid token.");
		}

		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			throw new Exception("Token expired.");
		}

		Korisnik user = verificationToken.getUser();
		user.setToken(null);
		user.setEnabled(true);
		repository.save(user);
		verificationTokenRepository.delete(verificationToken);
	}

	public Korisnik findByEmail(String email) {
		return repository.findByEmail(email);
	}


}

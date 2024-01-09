package com.example.burger.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.burger.models.Burger;
import com.example.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	//get all burger
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();
	}
	
	public Burger createBurger(Burger b) {
		return burgerRepository.save(b);
	}
	
}

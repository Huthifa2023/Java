package com.example.travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.travel.models.Travel;
import com.example.travel.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;
	
	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	//get all travels
	public List<Travel> allTravels(){
		return travelRepository.findAll();
	}
	
	public Travel createTravel(Travel b) {
		return travelRepository.save(b);
	}
	
	public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
	
	
	public void deleteTravel(Travel travel) {
		travelRepository.delete(travel);
	}
		
}

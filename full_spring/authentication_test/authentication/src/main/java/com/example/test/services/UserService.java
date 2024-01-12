package com.example.test.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.test.models.LoginUser;
import com.example.test.models.User;
import com.example.test.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> allUsers(){
    	return userRepository.findAll();
    }
    
    public User register(User newUser, BindingResult result) {
    	if(result.hasErrors()) {
        	return null;
        }
    	Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "error.user", "Email is already registered");
    		return null;
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())){
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
			return null;
    	}
    	String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPassword);
		userRepository.save(newUser);
		return newUser;
    }
    
    
    public User login(LoginUser newLoginObject, BindingResult result) {
    	if(result.hasErrors()) {
        	return null;
        }
    	Optional<User> user = userRepository.findByEmail(newLoginObject.getEmail());
    	if(!user.isPresent()) {
    		result.rejectValue("email", "error.user", "Email is not registered");
    		return null;
    	}
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.get().getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	    return null;
    	}
    	return user.get();
    }
}
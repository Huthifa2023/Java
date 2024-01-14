package com.example.login.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.login.models.LoginUser;
import com.example.login.models.User;
import com.example.login.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> findUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
	public Optional<User> findUserById(Long Id){
		return userRepository.findById(Id);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public User register(User user, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> maybeUser = userRepository.findByEmail(user.getEmail());
		if(maybeUser.isPresent()) {
			result.rejectValue("email", "error.user", "email already exists");
			return null;
		}
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "match", "the confirm password must match password");
			return null;
		}
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		userRepository.save(user);
		return user;
	}
	
	
	public User login(LoginUser newLogin, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> maybeUser = userRepository.findByEmail(newLogin.getEmail());
		if(!maybeUser.isPresent()) {
			result.rejectValue("email", "error.user", "email does not exist, please signUp");
			return null;
		}
		if(!BCrypt.checkpw(newLogin.getPassword(), maybeUser.get().getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	    return null;
    	}
		return maybeUser.get();
	}
	
}

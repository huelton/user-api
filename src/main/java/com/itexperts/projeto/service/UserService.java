package com.itexperts.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itexperts.projeto.model.User;
import com.itexperts.projeto.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User create(User user) {
		User u = new User();
		u = userRepository.save(user);
		return u;
	}

	public void update(User user, Long id) {
		Optional<User> userReturned = userRepository.findById(id);
		userReturned.orElseThrow(() -> new RuntimeException("User not Found"));

		userReturned.get().setName(user.getName());
		userReturned.get().setLastName(user.getLastName());
	    
		userRepository.save(userReturned.get());

	}

	public User getById(Long id) {
		Optional<User> userReturned = userRepository.findById(id);
		userReturned.orElseThrow(() -> new RuntimeException("User not Found"));
		
		return userReturned.get();
		
	}

}

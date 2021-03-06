package com.itexperts.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itexperts.projeto.model.User;
import com.itexperts.projeto.repository.UserRepository;
import com.itexperts.projeto.request.dto.RequestUpdateUserDTO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User create(User user) {
		User u = new User();
		u = userRepository.save(user);
		return u;
	}

	@Transactional
	public void update(RequestUpdateUserDTO dto, Long id) {
		Optional<User> userReturned = userRepository.findById(id);
		userReturned.orElseThrow(() -> new RuntimeException("User not Found"));
		
		convertDtoToEntity(dto, userReturned.get());
		
		userRepository.save(userReturned.get());
	}

	@Transactional(readOnly = true)
	public User getById(Long id) {
		Optional<User> userReturned = userRepository.findById(id);
		userReturned.orElseThrow(() -> new RuntimeException("User not Found"));
		
		return userReturned.get();		
	}
	
	@Transactional(readOnly = true)
	public List<User> getAll(){		
		List<User> users = userRepository.findAll();		
		return users;
	}	
	
	@Transactional(readOnly = true)
	public Page<User> getAll(Pageable pageable){		
		Page<User> users = userRepository.findAll(pageable);		
		return users;
	}	

	private void convertDtoToEntity(RequestUpdateUserDTO dto, User user) {
		user.setLastName(dto.getLastName());
		
	}

}

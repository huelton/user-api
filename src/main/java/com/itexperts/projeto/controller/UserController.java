package com.itexperts.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itexperts.projeto.model.User;
import com.itexperts.projeto.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		User u = new User();
		u = userService.create(user);		
		return ResponseEntity.ok().body(u);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody User user, @PathVariable Long id){
			userService.update(user, id);		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
			User user = userService.getById(id);		
		return ResponseEntity.ok().body(user);
	}	
	
	@GetMapping("/list")
	public ResponseEntity<List<User>> getAllList(){
			List<User> users = userService.getAll();		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<User>> getAllPage(Pageable pageable){
			Page<User> users = userService.getAll(pageable);		
		return ResponseEntity.ok().body(users);
	}
	

}

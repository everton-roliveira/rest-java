package br.com.restapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restapi.entity.User;
import br.com.restapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService _userService;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User obj = _userService.save(user);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
    	List<User> obj = _userService.findAll();
    	return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
    	return _userService.findById(id)
    	.map(data -> ResponseEntity.ok(data))
    	.orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user) {
    	return _userService.findById(id)
    			.map(data -> {
    				data.setName(user.getName());
    				data.setGender(user.getGender());
    				data.setEmail(user.getEmail());
    				data.setIsActive(user.getIsActive());
    				
    				User updated = _userService.save(data);
    				return ResponseEntity.accepted().body(updated);
    			}).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	return _userService.findById(id)
    			.map(data -> {
    				_userService.deleteById(id);
    				return ResponseEntity.ok().build();
    			}).orElse(ResponseEntity.notFound().build());
    }

}
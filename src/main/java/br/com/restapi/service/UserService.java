package br.com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restapi.dao.UserRepository;
import br.com.restapi.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    public List<User> findAll() {
        return _userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return _userRepository.findById(id);
    }

    public User save(User user) {
        return _userRepository.save(user);
    }

    public void deleteById(Long id) {
        _userRepository.deleteById(id);
    }

}
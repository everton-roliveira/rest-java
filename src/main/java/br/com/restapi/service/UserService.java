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

    public User findById(Long id) {
        Optional<User> optionalUser = _userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

    public User save(User user) {
        return _userRepository.save(user);
    }

    public void deleteById(Long id) {
        _userRepository.deleteById(id);
    }
}
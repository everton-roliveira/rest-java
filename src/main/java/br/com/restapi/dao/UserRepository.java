package br.com.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
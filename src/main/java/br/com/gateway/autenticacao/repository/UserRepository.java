package br.com.gateway.autenticacao.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gateway.autenticacao.model.User;

public interface UserRepository extends MongoRepository<User, UUID> {
	public List<User> findByName(String name);
}

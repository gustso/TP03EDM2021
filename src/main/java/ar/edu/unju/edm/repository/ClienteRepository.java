package ar.edu.unju.edm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Integer>{

}

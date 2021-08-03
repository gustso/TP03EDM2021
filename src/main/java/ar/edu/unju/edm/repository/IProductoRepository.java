package ar.edu.unju.edm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Producto;

@Repository
public interface IProductoRepository extends MongoRepository<Producto, Integer>{

}

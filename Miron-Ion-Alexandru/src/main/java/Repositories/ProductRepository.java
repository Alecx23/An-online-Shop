package Repositories;

import org.springframework.data.repository.CrudRepository;

import Clase.Produs;


public interface ProductRepository extends CrudRepository<Produs,Long>{

	Produs findByNume(String nume);
}

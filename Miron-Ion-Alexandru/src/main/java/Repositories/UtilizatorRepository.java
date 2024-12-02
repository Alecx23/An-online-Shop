package Repositories;

import org.springframework.data.repository.CrudRepository;

import Clase.Utilizator;

public interface UtilizatorRepository extends CrudRepository<Utilizator,Long>{

	Utilizator findByNume(String nume);
	Utilizator findByNumeAndParola(String nume, String parola);
}

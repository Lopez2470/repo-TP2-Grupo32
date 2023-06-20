package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Consejo;
@Repository
public interface IConsejoRepository extends CrudRepository<Consejo, Long>{
	//Lista los objetos Consejo por el estado de cada uno de los registros
	//enviamos el parametro booleano estado para listar de acuerdo a su valor(false, true)
	public List<Consejo> findByEstado(boolean estado);
	
	

}

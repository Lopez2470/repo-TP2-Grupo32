package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Servicio;

public interface IServicioRepository extends CrudRepository<Servicio, Long> {
	/*
	 * Metodo que lista de acuerdo al valor del atributo estado.
	 * Se listaran todos los registros con el valor de atributo 'true'.
	 */
	public List<Servicio> findByEstado(Boolean estado);

}

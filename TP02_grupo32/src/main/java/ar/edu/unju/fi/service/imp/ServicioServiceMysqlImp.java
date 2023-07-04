package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;

@Service("servicioServiceMysqlImp")
public class ServicioServiceMysqlImp implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private Servicio servicio;
	
	/**
	 * Metodo que devuelve la lista de objetos que tienen el estado
	 * 'true'
	 */
	@Override
	public List<Servicio> getServicios() {
		return servicioRepository.findByEstado(true);
	}

	//Devuelve un objeto Servicio
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	
	/**
	 * Metodo que agrega un objeto servicio, designando el valor 'true'
	 * al atributo 'estado'
	 */
	@Override
	public void guardarServ(Servicio servicio) {
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}

	//Metodo no utlizado
	@Override
	public Servicio buscarServicioById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo que modifica los valores de los atributos
	 * del objeto Servicio, indicando con el valor del atributo
	 * 'id' a cual se realizan los cambios
	 */
	@Override
	public void modificarServ(Servicio servicio) {
		servicio.setEstado(true);
		servicioRepository.save(servicio);

	}

	//Metodo no utilizado
	@Override
	public void eliminarServ(int id) {
		// TODO Auto-generated method stub

	}
	//Metodo no utilizado
	@Override
	public Servicio buscarServicioByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo que busca un objeto a travez de su atributo 'id' enviado como parametro.
	 * Devuelve el objeto con ese 'id' encontrado.
	 */
	@Override
	public Servicio getBy(Long id) {
		return servicioRepository.findById(id).get();
	}

	/**
	 * Metodo que 'elimina' on objeto de la lista de objetos Servicio.
	 * Cambia el valor del atributo 'estado' a 'false' para que no pueda
	 * ser listado. Borrado Virtual.
	 */
	@Override
	public void eliminar(Servicio servicio) {
		servicio.setEstado(false);
		servicioRepository.save(servicio);

	}

}

package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {
	
	//Métodos abstractos de la entidad Servicio
	//Retorna los objetos Servicio
	List<Servicio> getServicios();
	//Retorna el objeto Servicio
	Servicio getServicio();
	//Guarda el nuevo objeto Servicio
	void guardarServ(Servicio servicio);
	//Busca un objeto por el atributo codigo de servicio
	public Servicio buscarServicioById(int id);
	//Modifica un objeto Servicio
	void modificarServ(Servicio servicio);
	//Elimina un elemento Servicio
	void eliminarServ(int id);
	//Busca un objeto por el atributo nombre de servicio
	public Servicio buscarServicioByNombre(String nombre);
	
}

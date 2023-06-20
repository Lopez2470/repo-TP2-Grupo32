package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;

public interface IConsejoService {
	//Definicion de los Metodos abstractos, sin definición.
	//Devuelve la lista de objetos consejo.
	List<Consejo> getConsejos();
	//Devuelve el objeto consejo
	Consejo getConsejo();
	//Guarda el objeto consejo
	void guardarConsejo(Consejo consejo);
	//Realiza la busqueda de un objeto por el atributo codigoConsejo.
	public Consejo buscarConsejoById(int id);
	//Guarda las modificaciones realizadas al objeto
	void modificarConsejo(Consejo consejo);
	// Elimina el objeto seleccionado en el listado de consejos
	void eliminarConsejo(int id);
	//Realiza la busqueda de un objeto consejo por el atributo titulo.
	public Consejo buscarConsejoByTitulo(String titulo);
	
	//Nuevo atributo para interactuar con la DB
	public Consejo getBy(Long id);
	
	public void eliminar (Consejo consejo);
	
	
}

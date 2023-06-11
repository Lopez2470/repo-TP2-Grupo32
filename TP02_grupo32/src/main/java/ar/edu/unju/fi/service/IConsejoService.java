package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;

public interface IConsejoService {
	
	List<Consejo> getConsejos();
	
	Consejo getConsejo();
	
	void guardarConsejo(Consejo consejo);
	
	public Consejo buscarConsejoById(int id);
	
	void modificarConsejo(Consejo consejo);
	
	void eliminarConsejo(int id);
	
	public Consejo buscarConsejoByTitulo(String titulo);
}

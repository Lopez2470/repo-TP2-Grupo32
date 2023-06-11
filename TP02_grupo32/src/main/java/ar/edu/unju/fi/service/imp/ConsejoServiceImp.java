package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
@Service
public class ConsejoServiceImp implements IConsejoService{
	
	@Autowired
	private ListaConsejo listaConsejos;
	
	@Autowired
	private Consejo consejo;
	/**
	 * Metodo que devuelve la lista de consejos.
	 */
	@Override
	public List<Consejo> getConsejos() {
		return listaConsejos.getConsejos();
	}
	/**
	 * Metodo que devuelve el objeto consejo
	 */
	@Override
	public Consejo getConsejo() {
		return consejo;
	}
	/**
	* Metodo que guarda el objeto enviado como parametro
	* Recibe un objeto validado
	* @param consejo es el objeto de Consejo enviado como parametro
	* @return 
	*/
	@Override
	public void guardarConsejo(Consejo consejo) {
		getConsejos().add(consejo);
	}
	/**
	* Metodo que realiza la busqueda de un objeto
	* La busqueda la realiza comparando con el codigo de consejo enviado como parametro
	* @param recibe como parametro la variable int id que es el codigo de consejo
	* @return retorna el objeto encontrado a travez de su codigo de consejo enviado.
	*/
	@Override
	public Consejo buscarConsejoById(int id) {
		Consejo consejoAuxiliar = new Consejo();
		for(Consejo conse : getConsejos()){
			if(conse.getCodigoConsejo() == id) {
				consejoAuxiliar = conse;
				break;
			}
		}
		return consejoAuxiliar;
	}
	/** Metodo que guarda el objeto modificado enviado como parametro
	* Recibe un objeto con los nuevos valores de los atributos
	* @param objeto que tiene las modificaciones realizadas
	* @return 
	*/
	@Override
	public void modificarConsejo(Consejo consejo) {
		Consejo consejoAModificar = buscarConsejoById(consejo.getCodigoConsejo());
		consejoAModificar.setTituloConsejo(consejo.getTituloConsejo());
		consejoAModificar.setContenidoConsejo(consejo.getContenidoConsejo());
		consejoAModificar.setFechaPublicacionConsejo(consejo.getFechaPublicacionConsejo());
		consejoAModificar.setAutorConsejo(consejo.getAutorConsejo());
		consejoAModificar.setCategoriaConsejo(consejo.getCategoriaConsejo());
	}
	/** Metodo que elimina el objeto enviado 
	* Recibe el codigo de consejo para buscar enla lista y luego eliminarlo.
	* @param el codigo de consejo que sera eliminado.
	* @return 
	*/
	@Override
	public void eliminarConsejo(int id) {
		Consejo consejoAEliminar = buscarConsejoById(id);
		getConsejos().remove(consejoAEliminar);
	}
	/**
	* Metodo que realiza la busqueda de un objeto
	* La busqueda la realiza comparando con el titulo de consejo enviado como parametro
	* @param recibe como parametro la variable String titulo del consejo
	* @return retorna el objeto encontrado a travez del titulo de consejo enviado.
	*/
	@Override
	public Consejo buscarConsejoByTitulo(String titulo) {
		Consejo consejoAuxiliar = new Consejo();
		for(Consejo conse : getConsejos()){
			if(conse.getTituloConsejo().equals(titulo)){
				consejoAuxiliar = conse;
				break;
			}
		}
		return consejoAuxiliar;
	}	
}



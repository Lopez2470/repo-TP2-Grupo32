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
	
	@Override
	public List<Consejo> getConsejos() {
		return listaConsejos.getConsejos();
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}

	@Override
	public void guardarConsejo(Consejo consejo) {
		getConsejos().add(consejo);
	}
	
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

	@Override
	public void modificarConsejo(Consejo consejo) {
		Consejo consejoAModificar = buscarConsejoById(consejo.getCodigoConsejo());
		consejoAModificar.setTituloConsejo(consejo.getTituloConsejo());
		consejoAModificar.setContenidoConsejo(consejo.getContenidoConsejo());
		consejoAModificar.setFechaPublicacionConsejo(consejo.getFechaPublicacionConsejo());
		consejoAModificar.setAutorConsejo(consejo.getAutorConsejo());
		consejoAModificar.setCategoriaConsejo(consejo.getCategoriaConsejo());
	}

	@Override
	public void eliminarConsejo(int id) {
		Consejo consejoAEliminar = buscarConsejoById(id);
		getConsejos().remove(consejoAEliminar);
	}

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



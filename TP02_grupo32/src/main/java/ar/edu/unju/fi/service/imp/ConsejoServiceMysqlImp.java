package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
@Service("consejoServiceMysqlImp")
public class ConsejoServiceMysqlImp implements IConsejoService{

	//Declaracion de la Inyeccion de dependencia de la Interface IConsejoRepository
	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> getConsejos() {
		return consejoRepository.findByEstado(true);
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}

	@Override
	public void guardarConsejo(Consejo consejo) {
		consejo.setEstado(true);
		consejoRepository.save(consejo);
	}

	@Override
	public Consejo getBy(Long id) {
		return consejoRepository.findById(id).get();
	}

	@Override
	public void modificarConsejo(Consejo consejo) {
		//Consejo consejoAModificar = new Consejo();
		/*consejoAModificar.setId(consejo.getId());
		consejoAModificar.setCodigoConsejo(consejo.getCodigoConsejo());
		consejoAModificar.setTituloConsejo(consejo.getTituloConsejo());
		consejoAModificar.setContenidoConsejo(consejo.getContenidoConsejo());
		consejoAModificar.setFechaPublicacionConsejo(consejo.getFechaPublicacionConsejo());
		consejoAModificar.setAutorConsejo(consejo.getAutorConsejo());
		consejoAModificar.setCategoriaConsejo(consejo.getCategoriaConsejo());
        */
		//consejoAModificar.setEstado(true);
		consejo.setEstado(true);
		consejoRepository.save(consejo);	
	}

	@Override
	public void eliminar(Consejo consejo) {
		consejo.setEstado(false);
		consejoRepository.save(consejo);
		
	}

	@Override
	public Consejo buscarConsejoByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consejo buscarConsejoById(int id) {
		return null;
	}
	
	@Override
	public void eliminarConsejo(int id) {
		// TODO Auto-generated method stub
		
	}

}

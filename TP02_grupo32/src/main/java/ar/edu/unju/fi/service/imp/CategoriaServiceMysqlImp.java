package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;

@Service("categoriaServiceMysqlImp")
public class CategoriaServiceMysqlImp implements ICategoriaService {
	
	@Autowired
	private ICategoriaRepository categoriaRepository; 
	

	@Override
	public List<Categoria> getCategorias() {
		return (List<Categoria>) categoriaRepository.findAll();
	}

}

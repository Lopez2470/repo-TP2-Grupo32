package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service("alumnoServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService {

	@Autowired
	private ISucursalRepository sucursalRepository; 

	@Autowired
	private Sucursal sucursal;
	
	@Override
	public List<Sucursal> getSucursals() {
		return sucursalRepository.findByEstado(true);
	}
	
	@Override
	public Sucursal getBy(Long id) {
		return sucursalRepository.findById(id).get();
	}
	
	@Override
	public void modificarSucursal(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
	}

	@Override
	public void guardarSucursal(@Valid Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}
	
	@Override
	public void eliminar(Sucursal sucursal) {
		//eliminacion logica
		sucursal.setEstado(false);
		sucursalRepository.save(sucursal);
	}
	
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

	@Override
	public Sucursal buscarSucursalId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sucursal buscarSucursalNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminarSucursal(int id) {
		
	}

}

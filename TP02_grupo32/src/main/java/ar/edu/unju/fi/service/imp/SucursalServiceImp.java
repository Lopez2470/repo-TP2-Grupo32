package ar.edu.unju.fi.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements ISucursalService{

	@Autowired
	private Sucursal sucursal;

	@Autowired
	private ListaSucursal listaSucursales;
	
	//Metodo que devuelve lista de objetos sucursales.
	@Override
	public List<Sucursal> getSucursals() {
		// TODO Auto-generated method stub
		return listaSucursales.getSucursales();
	}
	//Metodo que devuelve objeto sucursal
	@Override
	public Sucursal getSucursal() {
		// TODO Auto-generated method stub
		return sucursal;
	}
	
	//Metodo que recibe una sucursal y lo guarda en la lista.
		@Override
		public void guardarSucursal(Sucursal sucursal) {
			getSucursals().add(sucursal);	
		}
	//**************************************************************************
	//Metodo que busca un objeto sucursal por su codigo y retorna el encontrado.
	@Override
	public Sucursal buscarSucursalId(int id) {
		Sucursal sucurEncontrada = new Sucursal();
		for (Sucursal sucu : getSucursals()) {
			if (sucu.getCodigo() == id) {
				sucurEncontrada = sucu;
				break;
			}
		}
		return sucurEncontrada;
	}
	
	//*****************************************************************************
	//Metodo que busca y muestra una sucursal por su nombre.  
	@Override
	public Sucursal buscarSucursalNombre(String nombre) {
		Sucursal sucurEncontrada = new Sucursal();
		for (Sucursal sucu : getSucursals()) {
			if (sucu.getNombre().equals(nombre)) {
				sucurEncontrada = sucu;
				break;
			}
		}
		return sucurEncontrada;
	}
	//*****************************************************************************
	//Metodo que guarda el objeto que recibe como parametro,
	//busca en la lista al objeto y guarda las modificaciones realizadas al objeto.
	// 
	@Override
	public void modificarSucursal(Sucursal sucursal) {
		Sucursal sucurEncontrada = new Sucursal();
		for (Sucursal sucu : getSucursals()) {
			if (sucu.getCodigo() == sucursal.getCodigo()) {
				sucurEncontrada = sucu;
				break;
			}
		}
		sucurEncontrada.setNombre(sucursal.getNombre());
		sucurEncontrada.setDireccion(sucursal.getDireccion());
		sucurEncontrada.setEmail(sucursal.getEmail());
		sucurEncontrada.setFechaInicio(sucursal.getFechaInicio());
		sucurEncontrada.setProvincia(sucursal.getProvincia());
		sucurEncontrada.setTelefono(sucursal.getTelefono());
	}
	//*****************************************************************************
	//Metodo para eliminar un objeto encontrado por su codigo. 
	@Override
	public void eliminarSucursal(int id) {
		Sucursal sucurEncontrada = new Sucursal();
		for (Sucursal sucu : getSucursals()) {
			if (sucu.getCodigo() == id) {
				sucurEncontrada = sucu;
				break;
			}
		}
		getSucursals().remove(sucurEncontrada);
	}
	
}

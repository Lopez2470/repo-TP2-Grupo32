package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;
import jakarta.validation.Valid;

public interface ISucursalService {

	    //retorna los objetos sucursal a listar.
		List<Sucursal> getSucursals();
		//Metodo que devuelve objeto sucursal.
		Sucursal getSucursal();
		
		//Metodo que busca un objeto sucursal por su codigo
		public Sucursal buscarSucursalId(int id);
		
		//Metodo que busca y muestra una sucursal por su nombre.  
		public Sucursal buscarSucursalNombre(String nombre);
		
		//metodo que modifica una sucursal
		void modificarSucursal(Sucursal sucursal);
		
		//Metodo que recibe una sucursal y guarda en la lista.
		void guardarSucursal(@Valid Sucursal sucursal);
		
		//Metodo para eliminar un objeto
		void eliminarSucursal(int id);
		
		public Sucursal getBy (Long id);
		
		void eliminar(Sucursal sucursal);
		
}

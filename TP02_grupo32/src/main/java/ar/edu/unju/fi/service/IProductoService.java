package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
	/*
	 * Metodos abstractos
	 */
	
	//Metodo que devuelve los objetos producto a listar.
	List<Producto> getProductos();
	
	//Metodo que devuelve el objeto producto.
	Producto getProducto();
	
	//Metodo que guarda un nuevo objeto producto.
	void guardarProducto(Producto producto);
	
	//Metodo que busca un objeto por el atributo codigo del producto
	public Producto buscarProductoById(int id);

	//Metodo que busca un objeto por el atriibuto nombre del producto.
	public Producto buscarProductoByNombre(String nombre);
	
	//Metodo que modifica un objeto producto.
	void modificarProducto(Producto producto);
	
	//Metodo que elimina un objeto producto.
	void borrarProducto(int id);
	
	//Metodos para la nueva conexion a la base de datos
	public Producto getBy(Long id);
	
	public void eliminar(Producto producto);
	

}

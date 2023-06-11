package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;

public interface IProductoService {
	/*
	 * Metodos abstractos
	 */
	
	//Metodo que devuelve los objetos producto a listar.
	List<Producto> getProductos();
	
	//Metodo que devuelve el objeto producto.
	Producto getProducto();
	
	//Metodo que guarda un nuevo objeto producto.
	void saveProducto(Producto producto);
	
	//Metodo que busca un objeto por el atributo codigo del producto
	public Producto findProductoById(int id);

	//Metodo que busca un objeto por el atriibuto nombre del producto.
	public Producto findProductoByNombre(String nombre);
	
	//Metodo que elimina un objeto producto.
	void modifyProducto(Producto producto);
	
	//
	void deleteProducto(int id);

}

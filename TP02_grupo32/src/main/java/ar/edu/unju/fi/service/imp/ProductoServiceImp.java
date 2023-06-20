package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;
@Service
public class ProductoServiceImp implements IProductoService{
	
	@Autowired
	private ListaProducto listaProductos;
	
	@Autowired
	private Producto producto;

	//Metodo que retorna la lista de objetos producto
	@Override
	public List<Producto> getProductos() {
		return listaProductos.getProductos();
	}
	
	//Metodo que retorna un objeto producto.
	@Override
	public Producto getProducto() {
		return producto;
	}

	//Metodo que recibe un objeto producto para ser guardado en la lista.
	@Override
	public void saveProducto(Producto producto) {
		getProductos().add(producto);	
	}

	/*
	 *Metodo que busca un objeto producto por el atributo codigo del producto.
	 *Devuelve el objeto encontrado. 
	 */
	@Override
	public Producto findProductoById(int id) {
		Producto productSaved = new Producto();
		for (Producto prod : getProductos()) {
			if (prod.getCodigoProducto() == id) {
				productSaved = prod;
				break;
			}
		}
		return productSaved;
	}

	/*
	 *Metodo que busca un objeto producto por el atributo nombre del producto.
	 *Devuelve el objeto encontrado. 
	 */ 
	@Override
	public Producto findProductoByNombre(String nombre) {
		Producto productSaved = new Producto();
		for (Producto prod : getProductos()) {
			if (prod.getNombreProducto().equals(nombre)) {
				productSaved = prod;
				break;
			}
		}
		return productSaved;
	}

	/*
	 *Metodo que guarda el objeto recibido como parametro.
	 *Busca en la lista al objeto enviado por la vista, y
	 *guarda las modificaciones realizadas al objeto. 
	 */
	@Override
	public void modifyProducto(Producto producto) {
		Producto productSaved = new Producto();
		for (Producto prod : getProductos()) {
			if (prod.getCodigoProducto() == producto.getCodigoProducto()) {
				productSaved = prod;
				break;
			}
		}
		productSaved.setNombreProducto(producto.getNombreProducto());
		productSaved.setPrecioProducto(producto.getPrecioProducto());
		productSaved.setCategoriaProducto(producto.getCategoriaProducto());
		productSaved.setDescuentoProducto(producto.getDescuentoProducto());	
	}

	/*
	 *Metodo que elimina el objeto seleccionado.
	 *Busca en la lista por el atributo enviado por la vista
	 *y elimina el objeto encontrado. 
	 */
	@Override
	public void deleteProducto(int id) {
		Producto productSaved = new Producto();
		for (Producto prod : getProductos()) {
			if (prod.getCodigoProducto() == id) {
				productSaved = prod;
				break;
			}
		}
		getProductos().remove(productSaved);
		
	}

}

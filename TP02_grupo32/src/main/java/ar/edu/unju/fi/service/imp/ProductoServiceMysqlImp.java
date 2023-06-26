package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceMysqlImp")
public class ProductoServiceMysqlImp implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private Producto producto;

	@Override
	public List<Producto> getProductos() {
		return productoRepository.findByEstado(true);
	}

	@Override
	public Producto getProducto() {
		return producto;
	}

	@Override
	public void guardarProducto(Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);

	}

	@Override
	public Producto getBy(Long id) {
		return productoRepository.findById(id).get();
	}
	
	@Override
	public void modificarProducto(Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);

	}

	@Override
	public void eliminar(Producto producto) {
		producto.setEstado(false);
		productoRepository.save(producto);
	}
	/**********************************************************/
	@Override
	public Producto buscarProductoById(int id) {
		return null;
	}
	
	@Override
	public Producto buscarProductoByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void borrarProducto(int id) {
		// TODO Auto-generated method stub
	}

}

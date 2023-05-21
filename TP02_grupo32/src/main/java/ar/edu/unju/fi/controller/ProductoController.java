package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	ListaProducto listaProductos = new ListaProducto();
	
	@GetMapping("/producto")
	public String getIndex() {
		return "productos";
	}
	
	@GetMapping("/listado")
	public String getListadoProductoPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos-listado";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return"productos-nuevo";
	}
	
	@PostMapping("/guardar")
	/* public model getGuardarProductoPage(@ModelAttribute("producto")Producto producto){ */
	public String getGuardarProductoPage(@ModelAttribute("producto")Producto producto){
		ModelAndView modelView = new ModelAndView("productos");
		listaProductos.getProductos().add(producto);
		modelView.addObject("productos", listaProductos.getProductos());
		/*return model;*/
		return"redirect:/producto/listado";
	}
	
	@GetMapping("/modificar/{codigoProd}")
	public String getModificarProductoPage(Model model, @PathVariable(value = "codigoProd") int codigoProd) {
		Producto productoEncontrado = new Producto();
		for(Producto prod : listaProductos.getProductos()){
			if(prod.getCodigoProducto() == codigoProd) {
				productoEncontrado = prod;
				break;
			}
		}
		model.addAttribute("producto", productoEncontrado);
		return"productos-modificar";
	}	
	
	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute("producto")Producto producto) {
		for(Producto prod : listaProductos.getProductos()){
			if(prod.getCodigoProducto() == producto.getCodigoProducto()) {
				prod.setNombreProducto(producto.getNombreProducto());
				prod.setPrecioProducto(producto.getPrecioProducto());
				prod.setCategoriaProducto(producto.getCategoriaProducto());
				prod.setDescuentoProducto(producto.getDescuentoProducto());
				break;
			}
		}
		return"redirect:/producto/listado";
	}
	
	@GetMapping("/eliminar/{codigoProducto}")
	public String eliminarProducto(@PathVariable(value="codigoProducto") int codigoProducto) {
		for(Producto prod : listaProductos.getProductos()) {
			if (prod.getCodigoProducto() == codigoProducto) {
				listaProductos.getProductos().remove(prod);
				break;
			}
		}
		return "redirect:/producto/listado";
	}

}
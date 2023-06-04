package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

@Controller
/*@RequestMapping("/producto")*/
@RequestMapping("/")
public class ProductoController {
	@Autowired
	private ListaProducto listaProductos;
	
	@Autowired
	private Producto producto;
	
	@GetMapping("producto")
	public String getIndex() {
		return "productos";
	}
	@GetMapping("producto/listado")
	/*@GetMapping("/listado")*/
	public String getListadoProductoPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos-listado";
	}
	
	@GetMapping("producto/nuevo")
	/*@GetMapping("/nuevo")*/
	public String getNuevoProducto(Model model) {
		model.addAttribute("producto", producto);
		return"productos-nuevo";
	}
	
	@PostMapping("producto/guardar")
	/*@PostMapping("/guardar")*/
	/* public model getGuardarProductoPage(@ModelAttribute("producto")Producto producto){ */
	public String getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result){
		ModelAndView modelView = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelView.setViewName("productos-nuevo");
			modelView.addObject("producto", producto);
			return "productos-nuevo";
		}
		listaProductos.getProductos().add(producto);
		modelView.addObject("productos", listaProductos.getProductos());
		/*return model;*/
		return"redirect:/producto/listado";
	}
	
	@GetMapping("producto/modificar/{codigoProd}")
	/*@GetMapping("/modificar/{codigoProd}")*/
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
	
	@PostMapping("producto/modificar")
	/*@PostMapping("/modificar")*/
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
			ModelAndView modelView = new ModelAndView("productos");
			if(result.hasErrors()) {
				modelView.setViewName("productos-modificar");
				modelView.addObject("producto", producto);
				return "productos-modificar";
			}	
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
	
	@GetMapping("producto/eliminar/{codigoProducto}")
	/*@GetMapping("/eliminar/{codigoProducto}")*/
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
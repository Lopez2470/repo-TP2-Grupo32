package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
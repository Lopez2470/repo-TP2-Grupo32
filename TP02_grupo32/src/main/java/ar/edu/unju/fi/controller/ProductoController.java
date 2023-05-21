package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	


}
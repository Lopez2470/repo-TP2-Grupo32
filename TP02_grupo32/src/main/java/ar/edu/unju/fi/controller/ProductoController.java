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
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ProductoController {
	/*
	@Autowired
	private ListaProducto listaProductos;
	@Autowired
	private Producto producto;
	*/
	// Se inyecta la interface que interactuará con el controller
	@Autowired
	private IProductoService productoService;
	// Metodo para devolver la pagina inicio de productos
	@GetMapping("producto")
	public String getIndex() {
		return "productos";
	}
	//Lista los productos cargados en la lista.
	@GetMapping("producto/listado")
	/*@GetMapping("/listado")*/
	public String getListadoProductoPage(Model model) {
		model.addAttribute("productos", productoService.getProductos());
		return "productos-listado";
	}
	//Metodo que devuelve la vista para la carga de un objeto.
	@GetMapping("producto/nuevo")
	/*@GetMapping("/nuevo")*/
	public String getNuevoProducto(Model model) {
		productoService.getProducto().setCodigoProducto(productoService.getProductos().get(productoService.getProductos().size()-1).getCodigoProducto()+1);
		model.addAttribute("producto", productoService.getProducto());
		return"productos-nuevo";
	}
	//Metodo que guarda el objeto validado enviado por la vista.
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
		/*productoService.getProductos().add(producto);*/
		productoService.saveProducto(producto);
		modelView.addObject("productos", productoService.getProductos());
		/*return model;*/
		return"redirect:/producto/listado";
	}
	// Metodo que envia a la vista los datos del objeto seleccionado para modificar.
	@GetMapping("producto/modificar/{codigoProd}")
	public String getModificarProductoPage(Model model, @PathVariable(value = "codigoProd") int codigoProd) {
		/*Producto productoEncontrado = new Producto();
		for(Producto prod : productoService.getProductos()){
			if(prod.getCodigoProducto() == codigoProd) {
				productoEncontrado = prod;
				break;
			}
		} */
		Producto productoEncontrado = productoService.findProductoById(codigoProd);
		model.addAttribute("producto", productoEncontrado);
		return"productos-modificar";
	}	
	//Metodo que recibe los datos del objeto a modificar.
	@PostMapping("producto/modificar")
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
			ModelAndView modelView = new ModelAndView("productos");
			if(result.hasErrors()) {
				modelView.setViewName("productos-modificar");
				modelView.addObject("producto", producto);
				return "productos-modificar";
			}	
			productoService.modifyProducto(producto);
			/*
		for(Producto prod : productoService.getProductos()){
			if(prod.getCodigoProducto() == producto.getCodigoProducto()) {
				prod.setNombreProducto(producto.getNombreProducto());
				prod.setPrecioProducto(producto.getPrecioProducto());
				prod.setCategoriaProducto(producto.getCategoriaProducto());
				prod.setDescuentoProducto(producto.getDescuentoProducto());
				break;
			}
		} */
		return"redirect:/producto/listado";
	}
	// Metodo que elimina el elemento seleccionado en el listado de la vista.
	@GetMapping("producto/eliminar/{codigoProducto}")
	/*@GetMapping("/eliminar/{codigoProducto}")*/
	public String eliminarProducto(@PathVariable(value="codigoProducto") int codigoProducto) {
		productoService.deleteProducto(codigoProducto);
		/*for(Producto prod : productoService.getProductos()) {
			if (prod.getCodigoProducto() == codigoProducto) {
				productoService.getProductos().remove(prod);
				break;
			}
		} */
		return "redirect:/producto/listado";
	}

}
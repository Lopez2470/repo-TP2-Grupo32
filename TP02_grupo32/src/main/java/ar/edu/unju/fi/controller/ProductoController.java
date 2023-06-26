package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ProductoController {
	// Se inyecta la interface que interactuará con el controller
	@Autowired
	@Qualifier("productoServiceMysqlImp")
	private IProductoService productoService;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	// Metodo para devolver la pagina inicio de productos
	@GetMapping("producto")
	public String getIndex() {
		return "productos";
	}
	//Lista los productos cargados en la lista.
	@GetMapping("producto/listado")
	public String getListadoProductoPage(Model model) {
		model.addAttribute("productos", productoService.getProductos());
		return "productos-listado";
	}
	//Metodo que devuelve la vista para la carga de un objeto.
	@GetMapping("producto/nuevo")
	public String getNuevoProducto(Model model) {
		boolean edicion = false;
		model.addAttribute("producto", productoService.getProducto());
		model.addAttribute("categoria", categoriaService.getCategorias());
		model.addAttribute("edicion", edicion);
		return "productos-nuevo2";
	}
	//Metodo que guarda el objeto validado enviado por la vista.
	@PostMapping("producto/guardar")
	public String getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result){
		ModelAndView modelView = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelView.setViewName("productos-nuevo2");
			modelView.addObject("productos", producto);
			modelView.addObject("edicion", true);
			modelView.addObject("categoria", categoriaService.getCategorias());
			return "productos-nuevo2";
		}
		productoService.guardarProducto(producto);
		modelView.addObject("productos", productoService.getProductos());
		
		return"redirect:/producto/listado";
	}
	// Metodo que envia a la vista los datos del objeto seleccionado para modificar.
	@GetMapping("producto/modificar/{id}")
	public String getModificarProductoPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion=true;
		Producto productoEncontrado = productoService.getBy(id);
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);
		model.addAttribute("categoria", categoriaService.getCategorias());
		return"productos-nuevo2";
	}	
	//Metodo que recibe los datos del objeto a modificar.
	@PostMapping("producto/modificar")
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto producto, BindingResult result, Model model) {
			boolean edicion=true;
			if(result.hasErrors()) {;
				model.addAttribute("edicion", edicion);
				model.addAttribute("categoria", categoriaService.getCategorias());
				return "productos-nuevo2";
			}	
			productoService.modificarProducto(producto);
		return"redirect:/producto/listado";
	}
	// Metodo que elimina el elemento seleccionado en el listado de la vista.
	@GetMapping("producto/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value="id") Long id) {
		/*Cambio en el metodo para eliminar, usando en del repository */
		productoService.eliminar(productoService.getBy(id));
		return "redirect:/producto/listado";
	}

}
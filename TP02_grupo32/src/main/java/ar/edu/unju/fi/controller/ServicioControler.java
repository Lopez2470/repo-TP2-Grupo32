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

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
/*@RequestMapping("/servicio")*/
public class ServicioControler {
	@Autowired
	private ListaServicio listaServicios = new ListaServicio();
	@Autowired
	private Servicio servicio;
	
	@GetMapping("servicio")
	public String getIndex() {
		return "servicio-de-paseo";
	}
	
	@GetMapping("servicio/listado")
	public String getListadoServicioPage(Model model) {
		model.addAttribute("servicios", listaServicios.getServicios());
		return "servicios-listado";
	}
	
	@GetMapping("servicio/nuevo")
	public String getNuevoServicio(Model model) {
		boolean edicion = false;
		model.addAttribute("servicio", servicio);
		model.addAttribute("edicion", edicion);
		return"servicios-nuevo";
	}
	
	@PostMapping("servicio/guardar")
	/* public model getGuardarProductoPage(@ModelAttribute("producto")Producto producto){ */
	public String getGuardarServicioPage(@Valid  @ModelAttribute("servicio")Servicio servicio, BindingResult result){
		ModelAndView modelView = new ModelAndView("servicios");
		if(result.hasErrors()) {
			modelView.setViewName("servicios-nuevo");
			modelView.addObject("servicio", servicio);
			return "servicios-nuevo";
		}
		listaServicios.getServicios().add(servicio);
		modelView.addObject("servicios", listaServicios.getServicios());
		/*return model;*/
		return"redirect:/servicio/listado";
	}
	
	@GetMapping("servicio/modificar/{codigoServ}")
	public String getModificarServicioPage(Model model, @PathVariable(value = "codigoServ") int codigoServ) {
		Servicio servicioEncontrado = new Servicio();
		boolean edicion=true;
		for(Servicio servi : listaServicios.getServicios()){
			if(servi.getCodigoServ() == codigoServ) {
				servicioEncontrado = servi;
				break;
			}
		}
		model.addAttribute("servicio", servicioEncontrado);
		model.addAttribute("edicion", edicion);
		return"servicios-nuevo";
	}	
	
	@PostMapping("servicio/modificar")
	public String modificarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result) {
		ModelAndView modelView = new ModelAndView("servicios");
		if(result.hasErrors()) {
			modelView.setViewName("servicios-nuevo");
			modelView.addObject("servicio", servicio);
			return "servicios-nuevo";
		}
		for(Servicio servic : listaServicios.getServicios()) {
			if(servic.getCodigoServ() == servicio.getCodigoServ()) {
				servic.setNombreServ(servicio.getNombreServ());
				servic.setDescripcionServ(servicio.getDescripcionServ());
				servic.setCategoriaServ(servicio.getCategoriaServ());
				servic.setPrecioServ(servicio.getPrecioServ());
				break;
			}
		}
		return "redirect:/servicio/listado";
	}
	
	@GetMapping("servicio/eliminar/{codigoServicio}")
	public String eliminarServicio(@PathVariable(value="codigoServicio") int codigoServicio) {
		for(Servicio serv : listaServicios.getServicios()) {
			if (serv.getCodigoServ() == codigoServicio) {
				listaServicios.getServicios().remove(serv);
				break;
			}
		}
		return "redirect:/servicio/listado";
	}


}
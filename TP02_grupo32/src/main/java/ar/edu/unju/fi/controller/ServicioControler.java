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

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")

public class ServicioControler {
	//Inyeccion de la capa intermedia entre el controlador y el modelo.
	@Autowired
	//Se usa la implementacion de la conexion a la base de datos
	@Qualifier("servicioServiceMysqlImp")
	private IServicioService servicioService;
	//Se inyecta el service de Empleado
	@Autowired
	private IEmpleadoService empleadoService;
	//Devuelve la pagina de inicio del Servicios
	@GetMapping("servicio")
	public String getIndex() {
		return "servicio-de-paseo";
	}
	//Devuelve a la vista todos los objetos a ser listados.
	@GetMapping("servicio/listado")
	public String getListadoServicioPage(Model model) {
		model.addAttribute("servicios", servicioService.getServicios());
		return "servicios-listado";
	}
	//Devuelve a la vista la pagina para realizar la carga de un nuevo elemento 'servicio'.
	@GetMapping("servicio/nuevo")
	public String getNuevoServicio(Model model) {
		boolean edicion = false;
		//se envia al browser la lista de empleados a travez de 'empleados'
		model.addAttribute("empleado", empleadoService.getEmpleados());
		model.addAttribute("servicio", servicioService.getServicio());
		model.addAttribute("edicion", edicion);
		return"servicios-nuevo";
	}
	//Guarda el objeto validado enviado por la vista.
	@PostMapping("servicio/guardar")
	public String getGuardarServicioPage(@Valid  @ModelAttribute("servicio")Servicio servicio, BindingResult result){
		ModelAndView modelView = new ModelAndView("servicios");
		boolean edicion = false;
		if(result.hasErrors()) {
			modelView.setViewName("servicios-nuevo");
			modelView.addObject("servicio", servicio);
			modelView.addObject("edicion", edicion);
			modelView.addObject("empleados", empleadoService.getEmpleados());
			return "servicios-nuevo";
		}
		servicioService.guardarServ(servicio);
		modelView.addObject("servicios", servicioService.getServicios());
		return"redirect:/servicio/listado";
	}
	/*Devuelve a la vista el objeto a modificar.
	 *El obejto es buscado por el valor del atributo que la vista envia. 
	 */
	@GetMapping("servicio/modificar/{id}")
	public String getModificarServicioPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion=true;
		model.addAttribute("servicio", servicioService.getBy(id));
		model.addAttribute("edicion", edicion);
		model.addAttribute("empleado", empleadoService.getEmpleados());
		return"servicios-nuevo";
	}	
	//Guarda las modificaciones validadas realizadas al objeto enviado.
	@PostMapping("servicio/modificar")
	public String modificarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("edicion", true);
			model.addAttribute("empleado", empleadoService.getEmpleados());
			return "servicios-nuevo";
		}
		servicioService.modificarServ(servicio);
		return "redirect:/servicio/listado";
	}
	//Elimina el objeto seleccionado, por medio del atributo enviado desde la vista.
	@GetMapping("servicio/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id") Long id) {
		servicioService.eliminar(servicioService.getBy(id));
		return "redirect:/servicio/listado";
	}
}
package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;

@Controller
@RequestMapping("/")
/*@RequestMapping("/servicio")*/
public class ServicioControler {
	ListaServicio listaServicios = new ListaServicio();
	@GetMapping("servicio")
	public String getIndex() {
		return "servicio-de-paseo";
	}
	
	@GetMapping("servicio/listado")
	public String getListadoServicioPage(Model model) {
		model.addAttribute("servicios", listaServicios.getServicios());
		return "servicios-listado";
	}
}
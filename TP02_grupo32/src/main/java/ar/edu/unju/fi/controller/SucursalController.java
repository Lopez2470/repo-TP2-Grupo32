package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;

@Controller
@RequestMapping("/")
public class SucursalController {
	
	ListaSucursal listaSucursales = new ListaSucursal();
	@GetMapping("sucursal/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}
	
	@GetMapping("sucursal/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion =false;
		model.addAttribute("sucursal", new Sucursal());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal){
		ModelAndView modelView = new ModelAndView ("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}
	
	@GetMapping("/modificar/{nombre}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="nombre") String nombre){
		Sucursal sucursalEncontrada = new Sucursal();
		boolean edicion= true;
		for(Sucursal sucu : listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(nombre)) {
				sucursalEncontrada= sucu;
				break;
			}
		}
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
		for (Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setEmail(sucursal.getEmail());
				sucu.setTelefono(sucursal.getTelefono());
			}
		}
		return "redirect:/sucursal/listado";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String elimnarSucursal(@PathVariable(value="nombre")String nombre) {
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(nombre)){
			listaSucursales.getSucursales().remove(sucu);
			break;
			}
		}
		return "redirect:/sucursal/listado";
	}
}

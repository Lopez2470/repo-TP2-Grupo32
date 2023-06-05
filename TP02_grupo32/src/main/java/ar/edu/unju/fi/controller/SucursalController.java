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

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/sucursal")

public class SucursalController {
		@Autowired
		private Sucursal sucursal;

		@Autowired
		ListaSucursal listaSucursales;
		
		@GetMapping("/listado")
		public String getListaSucursalesPage(Model model) {
			model.addAttribute("sucursales", listaSucursales.getSucursales());
			return "sucursales";
		}
		
		@GetMapping("/nuevo")
		public String getNuevaSucursalPage(Model model) {
			boolean edicion = false;
			model.addAttribute("edicion", edicion);
			model.addAttribute("sucursal", sucursal);
			return "nueva_sucursal";
		}
		
		@PostMapping("/guardar")
		public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result){
			ModelAndView modelView = new ModelAndView ("sucursales");
			if(result.hasErrors()) {
				modelView.setViewName("nueva_sucursal");
				modelView.addObject("sucursal", sucursal);
				return modelView;
			}
			listaSucursales.getSucursales().add(sucursal);
			modelView.addObject("sucursales", listaSucursales.getSucursales());
			return modelView;
		}
		
		@GetMapping("/modificar/{nombre}")
		public String getModificarSucursalPage(Model model, @PathVariable(value="nombre") String nombre){
			Sucursal sucursalEncontrada = new Sucursal();
			boolean edicion = true;
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
		

		
		/*
		 @PostMapping("consejo/modificar")
	public String modificarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		ModelAndView modelView = new ModelAndView("consejos");
		if(result.hasErrors()) {
			modelView.setViewName("consejos-nuevo");
			modelView.addObject("consejo", consejo);
			return "consejos-nuevo";
		}
		 */
		
		@PostMapping("/modificar")
		public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
			ModelAndView modelView = new ModelAndView("sucursales");
			if(result.hasErrors()) {
				modelView.setViewName("nueva_sucursal");
				modelView.addObject("sucursal", sucursal);
				return "nueva_sucursal";
			}
			for (Sucursal sucu : listaSucursales.getSucursales()) {
				if(sucu.getNombre().equals(sucursal.getNombre())) {
					sucu.setDireccion(sucursal.getDireccion());
					sucu.setEmail(sucursal.getEmail());
					sucu.setFechaInicio(sucursal.getFechaInicio());
					sucu.setProvincia(sucursal.getProvincia());
					sucu.setTelefono(sucursal.getTelefono());
				}
			}
			return "redirect:/sucursal/listado" ;
		}
		
		@GetMapping("/eliminar/{nombre}")
		public String eliminarSucursal(@PathVariable(value="nombre")String nombre) {
			for(Sucursal sucu: listaSucursales.getSucursales()) {
				if(sucu.getNombre().equals(nombre)) {
					listaSucursales.getSucursales().remove(sucu);
					break;
				}	
			}
			return "redirect:/sucursal/listado";
		}
	
}


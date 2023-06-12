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
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/sucursal")

public class SucursalController {
		//Inyección a la interface que interactua con el controller
		@Autowired
		private ISucursalService sucursalService;
		
		/*
		@Autowired
		private Sucursal sucursal;

		@Autowired
		ListaSucursal listaSucursales;
		*/
		
		@GetMapping("/listado")
		public String getListaSucursalesPage(Model model) {
			model.addAttribute("sucursales", sucursalService.getSucursals());
			return "sucursales";
		}
		
		@GetMapping("/nuevo")
		public String getNuevaSucursalPage(Model model) {
			boolean edicion = false;
			model.addAttribute("edicion", edicion);
			model.addAttribute("sucursal", sucursalService.getSucursal());
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
			sucursalService.guardarSucursal(sucursal);
			modelView.addObject("sucursales", sucursalService.getSucursals());
			return modelView;
		}
		
		@GetMapping("/modificar/{nombre}")
		public String getModificarSucursalPage(Model model, @PathVariable(value="nombre") String nombre){
			
			/*for(Sucursal sucu : sucursalService.getSucursals()) {
				if(sucu.getNombre().equals(nombre)) {
					sucursalEncontrada= sucu;
					break;
				}
			}
			 */
			Sucursal sucursalEncontrada = sucursalService.buscarSucursalNombre(nombre);
			boolean edicion = true;
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
			sucursalService.modificarSucursal(sucursal);
			/*for (Sucursal sucu : sucursalService.getSucursals()) {
				if(sucu.getNombre().equals(sucursal.getNombre())) {
					sucu.setDireccion(sucursal.getDireccion());
					sucu.setEmail(sucursal.getEmail());
					sucu.setFechaInicio(sucursal.getFechaInicio());
					sucu.setProvincia(sucursal.getProvincia());
					sucu.setTelefono(sucursal.getTelefono());
				}
			}*/
			return "redirect:/sucursal/listado" ;
		}
		
		@GetMapping("/eliminar/{codigo}")
		public String eliminarSucursal(@PathVariable(value="codigo")int codigo) {
			sucursalService.eliminarSucursal(codigo);
			/*for(Sucursal sucu: sucursalService.getSucursals()) {
				if(sucu.getCodigo().equals(codigo)) {
					sucursalService.getSucursals().remove(sucu);
					break;
				}	
			}*/
			return "redirect:/sucursal/listado";
		}
	
}


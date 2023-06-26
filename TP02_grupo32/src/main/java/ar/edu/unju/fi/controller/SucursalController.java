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

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/sucursal")

public class SucursalController {
		//Inyección a la interface que interactua con el controller
		@Autowired
		private ISucursalService sucursalService;
		
		@Autowired
		private IProvinciaService provinciaService;
		
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
		
		@GetMapping("/modificar/{id}")
		public String getModificarSucursalPage(Model model, @PathVariable(value="id") Long id){
			boolean edicion=true;
			model.addAttribute("sucursal",sucursalService.getBy(id));
			model.addAttribute("provincia", provinciaService.getProvincias());
			model.addAttribute("edicion", edicion);
			return "nueva_sucursal";
		}
		
		@PostMapping("/modificar")
		public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result, Model model) {
			//ModelAndView modelView = new ModelAndView("sucursales");
			if(result.hasErrors()) {
				model.addAttribute("edicion", true);
				model.addAttribute("sucursal", sucursalService.getSucursal());
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
	
		@GetMapping("/eliminar/{id}")
		public String eliminarSucursal(@PathVariable(value="id")Long id) {
			sucursalService.eliminar(sucursalService.getBy(id));
			/*for(Sucursal sucu: sucursalService.getSucursals()) {
				if(sucu.getCodigo().equals(codigo)) {
					sucursalService.getSucursals().remove(sucu);
					break;
				}	
			}*/
			return "redirect:/sucursal/listado";
		}
}


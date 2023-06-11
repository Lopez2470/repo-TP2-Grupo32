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

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
/*@RequestMapping("/consejo")*/
public class ConsejoController {
	//
	@Autowired
	private IConsejoService consejoService;
	
	@GetMapping("consejo")
	public String getConsejo() {
		return "consejos";
	}
	
	@GetMapping("consejo/listado")
	public String getListadoConsejoPage(Model model) {
		model.addAttribute("consejos", consejoService.getConsejos());
		return "consejos-listado";
	}
	
	@GetMapping("consejo/nuevo")
	public String getNuevoConsejo(Model model) {
		boolean edicion = false;
		model.addAttribute("consejo", consejoService.getConsejo());
		model.addAttribute("edicion", edicion);
		return"consejos-nuevo";
	}
	
	@PostMapping("consejo/guardar")
	public String getGuardarConsejoPage(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result){
		ModelAndView modelView = new ModelAndView("consejos");
		if(result.hasErrors()) {
			modelView.setViewName("consejos-nuevo");
			modelView.addObject("consejo", consejo);
			return "consejos-nuevo";
		}
		consejoService.guardarConsejo(consejo);
		modelView.addObject("consejos", consejoService.getConsejos());
		return"redirect:/consejo/listado";
	}
	
	@GetMapping("consejo/modificar/{codigoConsejo}")
	public String getModificarConsejo(Model model, @PathVariable(value = "codigoConsejo") int codigoConsejo) {
		Consejo consejoEncontrado = consejoService.buscarConsejoById(codigoConsejo);
		boolean edicion=true;
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return"consejos-nuevo";
	}	
	
	@PostMapping("consejo/modificar")
	public String modificarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("edicion", true);
			return "consejos-nuevo";
		}
		consejoService.modificarConsejo(consejo);
		return "redirect:/consejo/listado";
	}
		
	@GetMapping("consejo/eliminar/{codigoConsejo}")
	public String eliminarConsejo(@PathVariable(value="codigoConsejo") int codigoConsejo) {
		consejoService.eliminarConsejo(codigoConsejo);
		/*for(Consejo conse : consejoService.getConsejos()) {
			if (conse.getCodigoConsejo() == codigoConsejo) {
				consejoService.getConsejos().remove(conse);
				break;
			}
		}*/
		return "redirect:/consejo/listado";
	}
}
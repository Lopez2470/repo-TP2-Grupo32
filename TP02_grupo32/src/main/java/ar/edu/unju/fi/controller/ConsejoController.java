package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.model.Servicio;

@Controller
@RequestMapping("/")
/*@RequestMapping("/consejo")*/
public class ConsejoController {
	
	ListaConsejo listaConsejos = new ListaConsejo();
	
	@GetMapping("consejo")
	public String getConsejo() {
		return "consejos";
	}
	
	@GetMapping("consejo/listado")
	public String getListadoConsejoPage(Model model) {
		model.addAttribute("consejos", listaConsejos.getConsejos());
		return "consejos-listado";
	}
}
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
	
	@GetMapping("consejo/nuevo")
	public String getNuevoConsejo(Model model) {
		boolean edicion = false;
		model.addAttribute("consejo", new Consejo());
		model.addAttribute("edicion", edicion);
		return"consejos-nuevo";
	}
	
	@PostMapping("consejo/guardar")
	public String getGuardarConsejoPage(@ModelAttribute("consejo")Consejo consejo){
		ModelAndView modelView = new ModelAndView("consejos");
		listaConsejos.getConsejos().add(consejo);
		modelView.addObject("consejos", listaConsejos.getConsejos());
		return"redirect:/consejo/listado";
	}
	
	@GetMapping("consejo/modificar/{codigoConsejo}")
	public String getModificarConsejo(Model model, @PathVariable(value = "codigoConsejo") int codigoConsejo) {
		Consejo consejoEncontrado = new Consejo();
		boolean edicion=true;
		for(Consejo conse : listaConsejos.getConsejos()){
			if(conse.getCodigoConsejo() == codigoConsejo) {
				consejoEncontrado = conse;
				break;
			}
		}
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return"consejos-nuevo";
	}	
	
	@PostMapping("consejo/modificar")
	public String modificarConsejo(@ModelAttribute("consejo") Consejo consejo) {
		for(Consejo conse : listaConsejos.getConsejos()) {
			if(conse.getCodigoConsejo() == consejo.getCodigoConsejo()) {
				conse.setTituloConsejo(consejo.getTituloConsejo());
				conse.setContenidoConsejo(consejo.getContenidoConsejo());
				conse.setFechaPublicacionConsejo(consejo.getFechaPublicacionConsejo());
				conse.setAutorConsejo(consejo.getAutorConsejo());
				conse.setCategoriaConsejo(consejo.getCategoriaConsejo());
				break;
			}
		}
		return "redirect:/consejo/listado";
	}
}
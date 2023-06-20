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
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
/*@RequestMapping("/consejo")*/
public class ConsejoController {
	//Se inyecta la capa intermedia que actuará entre el controlador y la capa model.
	@Autowired
	private IConsejoService consejoService;
	
	@GetMapping("consejo")
	public String getConsejo() {
		return "consejos";
	}
	/*
	 *Toma peticion de la vista, método que devuelve listado de todos los objetos cargados
	 *Se envia a la vista consejoService.getConsejos() por medio de 'consejos'
	 *para que la vista los muestre. 
	 */
	@GetMapping("consejo/listado")
	public String getListadoConsejoPage(Model model) {
		model.addAttribute("consejos", consejoService.getConsejos());
		return "consejos-listado";
	}
	/*
	 * Toma peticion de la vista para la carga de un nuevo objeto.
	 * Se devuelve a la vista un objeto para la carga, y
	 * la cariable 'edicion' para distinguir entre una nueva carga y la modificacion.
	 */
	@GetMapping("consejo/nuevo")
	public String getNuevoConsejo(Model model) {
		boolean edicion = false;
		// Genera de forma automatica los codigos de consejo
		consejoService.getConsejo().setCodigoConsejo(consejoService.getConsejos().get(consejoService.getConsejos().size()-1).getCodigoConsejo()+1);
		model.addAttribute("consejo", consejoService.getConsejo());
		model.addAttribute("edicion", edicion);
		return"consejos-nuevo";
	}
	/*
	 * Método que recibe los datos cargados en la vista para ser guardados en la lista.
	 * Si la validacion es correcta, se guardan los datos invocando el método del service.
	 * En caso contrario se devuelve a la vista el objeto enviado.
	 */
	@PostMapping("consejo/guardar")
	public String getGuardarConsejoPage(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result){
		ModelAndView modelView = new ModelAndView("consejos");
		if(result.hasErrors()) {
			modelView.setViewName("consejos-nuevo");
			modelView.addObject("consejo", consejo);
			return "consejos-nuevo";
		}
		//Se invoca al método del service para realizar el guardado.
		consejoService.guardarConsejo(consejo);
		modelView.addObject("consejos", consejoService.getConsejos());
		return"redirect:/consejo/listado";
	}
	/*
	 * Método que recibe la peticion de modificar un elemento en el listado de objetos cargados.
	 * Recibe de la vista el valor del atributo a buscar para la modificacion.
	 * El método devuelve el objeto buscado para su modificacion 
	 * y la variable 'edicion' para identificar la accion a realizar.
	 */
	@GetMapping("consejo/modificar/{codigoConsejo}")
	public String getModificarConsejo(Model model, @PathVariable(value = "codigoConsejo") int codigoConsejo) {
		// Se realiza la busqueda a travez de un método definido en el service.
		Consejo consejoEncontrado = consejoService.buscarConsejoById(codigoConsejo);
		boolean edicion=true;
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return"consejos-nuevo";
	}	
	/*
	 * Método que recibe las modificaciones en el objeto enviado para guardarlos en la lista.
	 * Si pasa la validacion, el objeto es guardado utillizando el metodo que provee el service.
	 * En caso contrario, se devuelve a la vista el objeto enviado y
	 * la variable 'edicion' para identificar la accion en la vista. 
	 */
	@PostMapping("consejo/modificar")
	public String modificarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("edicion", true);
			return "consejos-nuevo";
		}
		//La modificacion se realizará  a travez de un metodo del service.
		consejoService.modificarConsejo(consejo);
		return "redirect:/consejo/listado";
	}
	/*
	 * Método que realiza la eliminacion del objeto.
	 * La vista envia el valor {codigoConsejo} seleccionado del listado,
	 * el método buscará este valor para luego borrar este objeto, mediante
	 * el método proporcionado por el service. 	
	 */
	@GetMapping("consejo/eliminar/{codigoConsejo}")
	public String eliminarConsejo(@PathVariable(value="codigoConsejo") int codigoConsejo) {
		//La eliminación se realiza invocando al metodo definido en el service.
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
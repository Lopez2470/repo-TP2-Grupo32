package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;
@Component
public class ListaConsejo {
	
	private List<Consejo> consejos;

	public ListaConsejo() {
		/*
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo(19900,"Alimentacion balanceada", "Es fundamental proporcionar una dieta equilibrada",LocalDate.of(2023, 5, 10),"Jose Perez","Alimentacion"));
		consejos.add(new Consejo(19901,"El ejercicio es clave", "Las mascotas necesitan activdad fisica",LocalDate.of(2023, 4, 12),"Amalia Muñoz","Actividad fisica"));
		consejos.add(new Consejo(19902,"Visitas regulares al veterinario", "Los chequeos regulares ayudan a detectar...",LocalDate.of(2023, 5, 9),"Juan Cruz","Visitas veterinarias"));
		consejos.add(new Consejo(19903,"Manten a tu mascota hidratada", "Las mascotas necesitan activdad fisica",LocalDate.of(2023, 1, 2),"Jose Perez","Alimentacion"));
		consejos.add(new Consejo(19904,"Control de parasitos", "Consulta a tu veterinario sobre los productos...",LocalDate.of(2023, 3, 7),"Juan Cruz","Visitas veterinarias"));
	*/
	}

	public List<Consejo> getConsejos() {
		return consejos;
	}

	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}
	
	
}

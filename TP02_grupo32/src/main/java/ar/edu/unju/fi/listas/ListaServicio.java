package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Servicio;
@Component
public class ListaServicio {
	
	private List<Servicio> servicios;
	
	public ListaServicio() {
		servicios = new ArrayList<Servicio>();
		servicios.add(new Servicio(70001,"Paseos","Paseos realizados por personas idoneas","horas",1500));
		servicios.add(new Servicio(70002,"Peluquería","Cortes de pelo","tarea",1000));
		servicios.add(new Servicio(70003,"Limpieza","Aseos personalizados","tarea",2500));
		servicios.add(new Servicio(70004,"Guarderia","Cuidado de mascotas las 24 hs","horas",3500));
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
}

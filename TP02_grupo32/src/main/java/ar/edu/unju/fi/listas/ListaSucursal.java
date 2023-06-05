package ar.edu.unju.fi.listas;

import ar.edu.unju.fi.model.Sucursal;

import java.util.List;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
@Component
public class ListaSucursal {
	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales =new ArrayList<Sucursal>();
		sucursales.add(new Sucursal(100,"Tienda de Mascotas 2","Lavalle 123","Jujuy",LocalDate.of(2023,2,28)
				        ,"tiendamascota2@gmail.com","388-4212121"));
		sucursales.add(new Sucursal(101,"Tienda de Mascotas 3","Alvear 23","Jujuy",LocalDate.of(2023,4,8)
			       		,"tiendamascota3@gmail.com","388-4232323"));
		sucursales.add(new Sucursal(102,"Tienda de Mascotas 4","San Martin 825","Salta",LocalDate.of(2023,1,2)
						,"tiendamascota4@gmail.com","388-4242424"));
		sucursales.add(new Sucursal(103,"Tienda de Mascotas 5","Alte Brown 1235","Jujuy",LocalDate.of(2023,12,28)
						,"tiendamascota5@gmail.com","388-4252525"));
		
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
	
}
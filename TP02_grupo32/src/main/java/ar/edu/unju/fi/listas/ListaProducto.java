package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Producto;
@Component
public class ListaProducto {
	private List<Producto> productos;
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("CatShow",80001,10500,"Alimento",10));
		productos.add(new Producto("Cucha Cama Moises",80002,4350,"Cuidado",15));
		productos.add(new Producto("Abrigo Buzo",80003,2500,"Cuidado",0));
		productos.add(new Producto("Pelota con cascabel",80004,6500,"Juguete",5));
		productos.add(new Producto("Royal Canin",80005,7500,"Alimento",0));
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	

}
package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;

public class ListaProducto {
	private List<Producto> productos;
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("CatShow",10001,10500,"Alimento",10));
		productos.add(new Producto("Cucha Cama Moises",30001,4350,"Cuidado",15));
		productos.add(new Producto("Abrigo Buzo",30002,2500,"Cuidado",0));
		productos.add(new Producto("Pelota con cascabel",20001,6500,"Juguete",5));
		productos.add(new Producto("Royal Canin",10002,7500,"Alimento",0));
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	

}
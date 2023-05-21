package ar.edu.unju.fi.model;

public class Producto {
	private String nombreProducto;
	private int codigoProducto;
	private double precioProducto;
	private String categoriaProducto;
	private int descuentoProducto;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombreProducto, int codigoProducto, double precioProducto, String categoriaProducto,
			int descuentoProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.codigoProducto = codigoProducto;
		this.precioProducto = precioProducto;
		this.categoriaProducto = categoriaProducto;
		this.descuentoProducto = descuentoProducto;
	}
	
	
/* Getters y Setters*/
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public int getDescuentoProducto() {
		return descuentoProducto;
	}

	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}
	
	public double calcularDescuento() {
		if (this.descuentoProducto <= 50) {
			return this.precioProducto*(100-this.descuentoProducto)/100;
		} else {
			return this.precioProducto;
		}
	}
	
	

}

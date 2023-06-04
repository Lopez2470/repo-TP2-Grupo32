package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class Producto {
	@Size(min = 5,message = "Minimo de caracteres permitidos para el Nombre es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos para un Nombre es 20")
	private String nombreProducto;
	@Min(value = 80000,message = "El minimo valor del código es 80000")
	@Max(value = 89999, message = "El máximo valor del código es 89999")
	private int codigoProducto;
	
	@Min(value = 1,message = "Ingrese un valor del Producto")
	private double precioProducto;
	@NotBlank(message = "Seleccione una categoria")
	private String categoriaProducto;
	@Min(value = 1,message = "El Mínimo porcentaje de descuento es 1 ")
	@Max(value = 99, message = "El Máximo porcentaje de descuento es 99")
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
			return (this.precioProducto*(100-this.descuentoProducto)/100);
		} else {
			return this.precioProducto;
		}
	}
	
	

}

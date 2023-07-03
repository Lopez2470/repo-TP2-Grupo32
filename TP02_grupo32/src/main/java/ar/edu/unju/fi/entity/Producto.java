package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "productos")
@Component
public class Producto {
	@Id
	//Generar valores numericos incrementandose de 1 en 1
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long id;
	
	@Column(name = "prod_nombre", length = 20, nullable = false)
	@Size(min = 5,message = "Minimo de caracteres permitidos para el Nombre es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos para un Nombre es 20")
	private String nombreProducto;
	
	@Column(name = "prod_codigo")
	@Min(value = 80000,message = "El minimo valor del código es 80000")
	@Max(value = 89999, message = "El máximo valor del código es 89999")
	private int codigoProducto;
	
	
	@Column(name = "prod_precio")
	@NotNull(message = "Ingrese un valor del Producto")
	//@Min(value = 1,message = "Ingrese un valor del Producto")
	private double precioProducto;
	
	@NotNull(message = "Ingrese un descuento del Producto")
	@Column(name = "prod_descuento")
	@Min(value = 1,message = "El Mínimo porcentaje de descuento es 1 ")
	@Max(value = 99, message = "El Máximo porcentaje de descuento es 99")
	private int descuentoProducto;
	
	@Column(name = "prod_estado", nullable = false)
	private boolean estado;
	
	@NotNull(message = "Seleccione una categoria")
	@ManyToOne
	@JoinColumn(name = "cat_id")
	
	private Categoria categoria;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
		
	
/* Getters y Setters*/
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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


	public int getDescuentoProducto() {
		return descuentoProducto;
	}


	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public double calcularDescuento() {
		if (this.descuentoProducto <= 50) {
			return (this.precioProducto*(100-this.descuentoProducto)/100);
		} else {
			return this.precioProducto;
		}
	}
}

package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class Servicio {
	@Min(value = 70000,message = "El minimo valor del código es 70000")
	@Max(value = 79999, message = "El máximo valor del código es 79999")
	private int codigoServ;
	@Size(min = 5,message = "Minimo de caracteres permitidos para el nombre es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos para un Nombre es 20")
	private String nombreServ;
	@Size(min = 5,message = "Minimo de caracteres permitidos es 5")
	@Size(max = 30, message = "Máximo de caracteres permitidos es 20")
	private String descripcionServ;
	@NotBlank(message = "Seleccione una categoria")
	private String categoriaServ;
	@Min(value = 1,message = "Ingrese precio de Servicio")
	/*@NotNull(message="El precio es obligatorio")*/
    @Min(value=1, message="El precio mínimo es superior a 1,0")
	private double precioServ;
	
	public Servicio() {
		// TODO Auto-generated constructor stub
	}

	public Servicio(int codigoServ, String nombreServ, String descripcionServ, String categoriaServ,
			double precioServ) {
		super();
		this.codigoServ = codigoServ;
		this.nombreServ = nombreServ;
		this.descripcionServ = descripcionServ;
		this.categoriaServ = categoriaServ;
		this.precioServ = precioServ;
	}

	public int getCodigoServ() {
		return codigoServ;
	}

	public void setCodigoServ(int codigoServ) {
		this.codigoServ = codigoServ;
	}

	public String getNombreServ() {
		return nombreServ;
	}

	public void setNombreServ(String nombreServ) {
		this.nombreServ = nombreServ;
	}

	public String getDescripcionServ() {
		return descripcionServ;
	}

	public void setDescripcionServ(String descripcionServ) {
		this.descripcionServ = descripcionServ;
	}

	public String getCategoriaServ() {
		return categoriaServ;
	}

	public void setCategoriaServ(String categoriaServ) {
		this.categoriaServ = categoriaServ;
	}

	public double getPrecioServ() {
		return precioServ;
	}

	public void setPrecioServ(double precioServ) {
		this.precioServ = precioServ;
	}
	
	
	

}

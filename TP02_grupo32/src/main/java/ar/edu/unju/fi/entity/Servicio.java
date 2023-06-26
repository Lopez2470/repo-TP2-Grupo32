package ar.edu.unju.fi.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serv_id")
	private Long id;
	
	@Column(name = "serv_codigo")
	@Min(value = 70000,message = "El minimo valor del código es 70000")
	@Max(value = 79999, message = "El máximo valor del código es 79999")
	private int codigoServ;
	
	@Column(name = "serv_nombre", length = 20, nullable = false)
	@Size(min = 5,message = "Minimo de caracteres permitidos para el nombre es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos para un Nombre es 20")
	private String nombreServ;
	
	@Column(name = "serv_descripcion", length = 30, nullable = false)
	@Size(min = 5,message = "Minimo de caracteres permitidos es 5")
	@Size(max = 30, message = "Máximo de caracteres permitidos es 20")
	private String descripcionServ;
	
	@Column(name = "serv_categoria", length = 15, nullable = false)
	@NotBlank(message = "Seleccione una categoria")
	private String categoriaServ;
	
	@Column(name = "serv_precio")
	@Min(value = 1,message = "Ingrese precio de Servicio")
	/*@NotNull(message="El precio es obligatorio")*/
    @Min(value=1, message="El precio mínimo es superior a 1,0")
	private double precioServ;
	
	@Autowired
	@JoinColumn(name = "emp_id")
	@ManyToOne()
	@NotNull(message = "Debe seleccionar un Empleado")
	private Empleado empleado;
	
	@Column(name = "serv_estado", nullable = false)
	private boolean estado;
	
	
public Servicio() {
	// TODO Auto-generated constructor stub
}


public Servicio(Long id,
		@Min(value = 70000, message = "El minimo valor del código es 70000") @Max(value = 79999, message = "El máximo valor del código es 79999") int codigoServ,
		@Size(min = 5, message = "Minimo de caracteres permitidos para el nombre es 5") @Size(max = 20, message = "Máximo de caracteres permitidos para un Nombre es 20") String nombreServ,
		@Size(min = 5, message = "Minimo de caracteres permitidos es 5") @Size(max = 30, message = "Máximo de caracteres permitidos es 20") String descripcionServ,
		@NotBlank(message = "Seleccione una categoria") String categoriaServ,
		@Min(value = 1, message = "Ingrese precio de Servicio") @Min(value = 1, message = "El precio mínimo es superior a 1,0") double precioServ,
		@NotNull(message = "Debe seleccionar un Empleado") Empleado empleado, boolean estado) {
	super();
	this.id = id;
	this.codigoServ = codigoServ;
	this.nombreServ = nombreServ;
	this.descripcionServ = descripcionServ;
	this.categoriaServ = categoriaServ;
	this.precioServ = precioServ;
	this.empleado = empleado;
	this.estado = estado;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
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


public Empleado getEmpleado() {
	return empleado;
}


public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}


public boolean isEstado() {
	return estado;
}


public void setEstado(boolean estado) {
	this.estado = estado;
}


	
	
	

}

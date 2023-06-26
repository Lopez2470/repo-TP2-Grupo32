package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@Column(name = "emp_apellido", length = 20, nullable = false)
	@Size(min = 3,message = "Minimo de caracteres permitidos para el nombre es 3")
	@Size(max = 20, message = "Máximo de caracteres permitidos para un Nombre es 20")
	private String apellidoEmp;
	
	@Column(name = "emp_nombre", length = 30, nullable = false)
	@Size(min = 3,message = "Minimo de caracteres permitidos para el nombre es 3")
	@Size(max = 30, message = "Máximo de caracteres permitidos para un Nombre es 30")
	private String nombreEmp;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(Long id,
			@Size(min = 3, message = "Minimo de caracteres permitidos para el nombre es 3") @Size(max = 20, message = "Máximo de caracteres permitidos para un Nombre es 20") String apellidoEmp,
			@Size(min = 3, message = "Minimo de caracteres permitidos para el nombre es 3") @Size(max = 30, message = "Máximo de caracteres permitidos para un Nombre es 30") String nombreEmp) {
		super();
		this.id = id;
		this.apellidoEmp = apellidoEmp;
		this.nombreEmp = nombreEmp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellidoEmp() {
		return apellidoEmp;
	}

	public void setApellidoEmp(String apellidoEmp) {
		this.apellidoEmp = apellidoEmp;
	}

	public String getNombreEmp() {
		return nombreEmp;
	}

	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}
}

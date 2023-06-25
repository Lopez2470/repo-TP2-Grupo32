package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name="sucursales")
public class Sucursal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sucu_id")
	//@Min(value = 1,message = "El minimo valor del código es 100")
	//@Max(value = 9999, message = "El máximo valor del código es 999")
	private Long id;
	
	@Size(min = 1,message = "Minimo de caracteres permitidos para el título es 8")
	@Size(max = 30, message = "Máximo de caracteres permitidos para un título es 30")
	@Column(name="sucu_nombre",length = 30,nullable = false)
	private String nombre;
	
	@Size(min = 8,message = "Minimo de caracteres permitidos es 8")
	@Size(max = 30, message = "Máximo de caracteres permitidos es 30")
	@Column(name="sucu_direccion",nullable = false)
	private String direccion;
	
	@NotBlank(message = "Seleccione una provincia")
	@Column(name="sucu_provincia")
	private String provincia;
	
	@NotNull(message = "Ingrese una fecha")
	@Past(message = "Ingrese una fecha anterior a la actual")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="sucu_fecha_inicio")
	private LocalDate fechaInicio;
	
	@Email(message = "Ingrese un email válido")
	@NotEmpty(message = "Ingrese un email")
	@Column(name="sucu_email")
	private String email;
	
	@NotEmpty(message = "Ingrese un nro de celular")
	@Column(name="sucu_telefono")
	private String telefono;

	@Column(name="sucu_estado")
	private boolean estado;
	

	public Sucursal() {
		// TODO Auto-generated constructor stub
	}
	
	public Sucursal(Long id, String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono,Boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setCodigo(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

}

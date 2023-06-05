package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Component
public class Sucursal {
	@Min(value = 100,message = "El minimo valor del código es 100")
	@Max(value = 999, message = "El máximo valor del código es 999")
	private int codigo;
	@Size(min = 8,message = "Minimo de caracteres permitidos para el título es 8")
	@Size(max = 30, message = "Máximo de caracteres permitidos para un título es 30")
	private String nombre;
	@Size(min = 8,message = "Minimo de caracteres permitidos es 8")
	@Size(max = 30, message = "Máximo de caracteres permitidos es 30")
	private String direccion;
	@NotBlank(message = "Seleccione una provincia")
	private String provincia;
	@NotNull(message = "Ingrese una fecha")
	@Past(message = "Ingrese una fecha anterior a la actual")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaInicio;
	@Email(message = "Ingrese un email válido")
	@NotEmpty(message = "Ingrese un email")
	private String email;
	@NotEmpty(message = "Ingrese un nro de celular")
	private String telefono;
	
public Sucursal() {
	// TODO Auto-generated constructor stub
}

public Sucursal(int codigo, String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
		String telefono) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.direccion = direccion;
	this.provincia = provincia;
	this.fechaInicio = fechaInicio;
	this.email = email;
	this.telefono = telefono;
}

public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
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


	

}

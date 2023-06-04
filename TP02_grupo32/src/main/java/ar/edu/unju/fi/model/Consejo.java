package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Component
public class Consejo {

	@Min(value = 10000,message = "El minimo valor del código es 10000")
	@Max(value = 19999, message = "El máximo valor del código es 19999")
	private int codigoConsejo;
	@Size(min = 8,message = "Minimo de caracteres permitidos para el título es 8")
	@Size(max = 40, message = "Máximo de caracteres permitidos para un título es 30")
	private String tituloConsejo;
	@Size(min = 20,message = "Minimo de caracteres permitidos para el contenido es 50")
	@Size(max = 100, message = "Máximo de caracteres permitidos para un contenido es 100")
	private String contenidoConsejo;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull(message = "Ingrese una fecha")
	@Past(message = "Ingrese una fecha anterior a la actual")
	LocalDate fechaPublicacionConsejo;
	@Size(min = 5,message = "Minimo de caracteres permitidos para Nombre de autor es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos para un contenido es 20")
	private String autorConsejo;
	@NotBlank(message = "Seleccione una categoria")
	private String categoriaConsejo;
	
	public Consejo() {
		// TODO Auto-generated constructor stub
	}

	public Consejo(int codigoConsejo, String tituloConsejo, String contenidoConsejo, LocalDate fechaPublicacionConsejo,
			String autorConsejo, String categoriaConsejo) {
		super();
		this.codigoConsejo = codigoConsejo;
		this.tituloConsejo = tituloConsejo;
		this.contenidoConsejo = contenidoConsejo;
		this.fechaPublicacionConsejo = fechaPublicacionConsejo;
		this.autorConsejo = autorConsejo;
		this.categoriaConsejo = categoriaConsejo;
	}

	public int getCodigoConsejo() {
		return codigoConsejo;
	}

	public void setCodigoConsejo(int codigoConsejo) {
		this.codigoConsejo = codigoConsejo;
	}

	public String getTituloConsejo() {
		return tituloConsejo;
	}

	public void setTituloConsejo(String tituloConsejo) {
		this.tituloConsejo = tituloConsejo;
	}

	public String getContenidoConsejo() {
		return contenidoConsejo;
	}

	public void setContenidoConsejo(String contenidoConsejo) {
		this.contenidoConsejo = contenidoConsejo;
	}

	public LocalDate getFechaPublicacionConsejo() {
		return fechaPublicacionConsejo;
	}

	public void setFechaPublicacionConsejo(LocalDate fechaPublicacionConsejo) {
		this.fechaPublicacionConsejo = fechaPublicacionConsejo;
	}

	public String getAutorConsejo() {
		return autorConsejo;
	}

	public void setAutorConsejo(String autorConsejo) {
		this.autorConsejo = autorConsejo;
	}

	public String getCategoriaConsejo() {
		return categoriaConsejo;
	}

	public void setCategoriaConsejo(String categoriaConsejo) {
		this.categoriaConsejo = categoriaConsejo;
	}
	
	
}

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name = "consejos")
public class Consejo {
	@Id
	//Generar valores numericos incrementandose de 1 en 1
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "con_id")
	private Long id;
	@Min(value = 10000,message = "El minimo valor del código es 10000")
	@Max(value = 19999, message = "El máximo valor del código es 19999")
	@Column(name = "con_codigo")
	private int codigoConsejo;
	@Size(min = 8,message = "Minimo de caracteres permitidos para el título es 8")
	@Size(max = 40, message = "Máximo de caracteres permitidos para un título es 30")
	@Column(name = "con_titulo", length = 30, nullable = false)
	private String tituloConsejo;
	@Size(min = 20,message = "Minimo de caracteres permitidos para el contenido es 50")
	@Size(max = 100, message = "Máximo de caracteres permitidos para un contenido es 100")
	@Column(name = "con_contenido",length = 100, nullable = false)
	private String contenidoConsejo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Ingrese una fecha")
	@Past(message = "Ingrese una fecha anterior a la actual")
	@Column(name = "con_fecha", nullable = false)
	private LocalDate fechaPublicacionConsejo;
	@Size(min = 5,message = "Minimo de caracteres permitidos para Nombre de autor es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos para un contenido es 20")
	@Column(name = "con_autor",length = 30, nullable = false)
	private String autorConsejo;
	/**
	 * Se agregaron dos atributos:
	 * La clase Categoria para relacionar a otra tabla
	 * El atributo estado para realizar las bajas logicas.
	 */
	@NotBlank(message = "Seleccione una categoria")
	@Column(name = "con_categoria", nullable = false)
	private String categoriaConsejo;
	@Column(name = "con_estado", nullable = false)
	private boolean estado;
	
	public Consejo() {
		// TODO Auto-generated constructor stub
	}

	//Se volvieron a generar el constructor parametrizado y los getter - setters
	public Consejo(Long id,
			@Min(value = 10000, message = "El minimo valor del código es 10000") @Max(value = 19999, message = "El máximo valor del código es 19999") int codigoConsejo,
			@Size(min = 8, message = "Minimo de caracteres permitidos para el título es 8") @Size(max = 40, message = "Máximo de caracteres permitidos para un título es 30") String tituloConsejo,
			@Size(min = 20, message = "Minimo de caracteres permitidos para el contenido es 50") @Size(max = 100, message = "Máximo de caracteres permitidos para un contenido es 100") String contenidoConsejo,
			@NotNull(message = "Ingrese una fecha") @Past(message = "Ingrese una fecha anterior a la actual") LocalDate fechaPublicacionConsejo,
			@Size(min = 5, message = "Minimo de caracteres permitidos para Nombre de autor es 5") @Size(max = 20, message = "Máximo de caracteres permitidos para un contenido es 20") String autorConsejo,
			@NotBlank(message = "Seleccione una categoria") String categoriaConsejo, boolean estado) {
		super();
		this.id = id;
		this.codigoConsejo = codigoConsejo;
		this.tituloConsejo = tituloConsejo;
		this.contenidoConsejo = contenidoConsejo;
		this.fechaPublicacionConsejo = fechaPublicacionConsejo;
		this.autorConsejo = autorConsejo;
		this.categoriaConsejo = categoriaConsejo;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Consejo {

	private int codigoConsejo;
	private String tituloConsejo;
	private String contenidoConsejo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	LocalDate fechaPublicacionConsejo;
	private String autorConsejo;
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

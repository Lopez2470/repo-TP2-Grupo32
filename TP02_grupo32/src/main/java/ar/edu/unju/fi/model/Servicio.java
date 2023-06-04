package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Servicio {
	private int codigoServ;
	private String nombreServ;
	private String descripcionServ;
	private String categoriaServ;
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

package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	//Generar valores numericos incrementandose de 1 en 1
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_id")
	private Long id;
	
	@Column(name = "cat_descripcion", length = 20, nullable = false)
	private String descripcion;
	
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}


	public Categoria(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

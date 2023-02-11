package com.example.demo.modelo.dto;

public class EstudianteDTO {

	private String nombre;
	private String apellido;
	private String cedula;
	private String genero;
	
	public EstudianteDTO(){
		
	}
	
	public EstudianteDTO(String nombre, String apellido, String cedula, String genero) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.genero = genero;
	}
	

	

	@Override
	public String toString() {
		return "EstudianteDTO [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", genero="
				+ genero + "]";
	}

	// SET Y GET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}

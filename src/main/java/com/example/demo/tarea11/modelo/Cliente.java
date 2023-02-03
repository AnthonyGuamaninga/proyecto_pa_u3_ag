package com.example.demo.tarea11.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name="clie_cedula")
	private String cedula;
	@Column(name="clie_nombre")
	private String nombre;
	@Column(name="clie_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name="clie_numero_telefono")
	private String numeroTelefono;
	
	@ManyToMany(mappedBy = "cliente")
	private List<Renta> rentas;

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", cedula=" + cedula + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	
	
}

package com.example.demo.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
																													// .
@NamedQueries({
		@NamedQuery(name = "Estudiante.buscarPorNombre", query = "select e from Estudiante e where e.nombre = :datoNombre"),
		@NamedQuery(name = "Estudiante.buscarPorNombre1", query = "select e from Estudiante e where e.nombre = :datoNombre"),
		@NamedQuery(name = "Estudiante.buscarPorNombre2", query = "select e from Estudiante e where e.nombre = :datoNombre") }) // Nombre

@NamedNativeQueries({
		@NamedNativeQuery(name = "Estudiante.buscarPorNombreNative", query = "select * from estudiante where estu_nombre = :datoNombre", resultClass = Estudiante.class),
		@NamedNativeQuery(name = "Estudiante.buscarPorNombreNative1", query = "select * from estudiante where estu_nombre = :datoNombre", resultClass = Estudiante.class),
		@NamedNativeQuery(name = "Estudiante.buscarPorNombreNative2", query = "select * from estudiante where estu_nombre = :datoNombre", resultClass = Estudiante.class) }) // Anotacion
																																												// arreglos
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_seq")
	@SequenceGenerator(name = "estu_seq", sequenceName = "estu_seq", allocationSize = 1)
	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_genero")
	private String genero;

	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_ciudad")
	private String ciudad;

	@Column(name = "estu_pais")
	private String pais;

	@Column(name = "estu_hobby")
	private String hobby;

	@Column(name = "estu_salario")
	private BigDecimal salario;

	@Column(name = "estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", cedula=" + cedula + ", ciudad=" + ciudad + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}

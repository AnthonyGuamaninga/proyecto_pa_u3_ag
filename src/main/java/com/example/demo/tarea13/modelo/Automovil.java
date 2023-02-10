package com.example.demo.tarea13.modelo;

import java.math.BigDecimal;

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
@Table(name="automovil")

@NamedQueries({
		@NamedQuery(name = "Automovil.buscarPrecio", query = "select a from Automovil a where a.precio = :datoPrecio"),
		@NamedQuery(name = "Automovil.buscarMotor", query = "select a from Automovil a where a.motor = :datoMotor"),
		@NamedQuery(name = "Automovil.buscarAnio", query = "select a from Automovil a where a.anio = :datoAnio")
})

@NamedNativeQueries({
	@NamedNativeQuery(name="Automovil.FirstColorYMarca", query = "select * from automovil where auto_color = :datoColor and auto_marca= :datoMarca", resultClass = Automovil.class),
	@NamedNativeQuery(name="Automovil.FirstPrecioYModelo", query = "select * from automovil where auto_precio = :datoPrecio and auto_modelo= :datoModelo", resultClass = Automovil.class),
	@NamedNativeQuery(name="Automovil.FirstMotorYAño", query = "select * from automovil where auto_motor = :datoMotor and auto_anio= :datoAnio", resultClass = Automovil.class)
	
})


public class Automovil {

	@Id
	@SequenceGenerator(name="auto_seq", sequenceName = "auto_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_seq")
	@Column(name="auto_id")
	private Integer id;
	@Column(name="auto_placa")
	private String placa;
	@Column(name="auto_marca")
	private String marca;
	@Column(name="auto_modelo")
	private String modelo;
	@Column(name="auto_motor")
	private String motor;
	@Column(name="auto_anio")
	private String anio;
	@Column(name="auto_color")
	private String color;
	@Column(name="auto_precio")
	private BigDecimal precio;
	
	
	@Override
	public String toString() {
		return "Automovil [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", anio="
				+ anio + ", color=" + color + ", precio=" + precio + "]";
	}
	
	//SET Y GET
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	
	
}

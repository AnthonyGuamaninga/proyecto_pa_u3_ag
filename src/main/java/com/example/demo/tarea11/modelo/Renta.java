package com.example.demo.tarea11.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="renta")
public class Renta {

	@Id
	@SequenceGenerator(name="rent_seq", sequenceName = "rent_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rent_seq")
	@Column(name="rent_id")
	private Integer id;
	@Column(name="rent_fecha")
	private LocalDateTime fecha;
	@Column(name="rent_numero_dias")
	private Integer numeroDias;
	@Column(name="rent_valor")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "rent_id_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "rent_id_vehiculo")
	private Vehiculo vehiculo;
	
	// SET Y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Integer getNumeroDias() {
		return numeroDias;
	}
	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}


	
	
}

package com.example.demo.tarea11.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo { // PRINCIPAL

	@Id
	@Column(name="vehi_placa")
	private String placa;	
	@Column(name="vehi_marca")
	private String marca;
	@Column(name="vehi_anio")
	private LocalDateTime anio;
	@Column(name="vehi_modelo")
	private String modelo;
	@Column(name="vehi_valor")
	private BigDecimal valor;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Renta> rentas;
	
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", placa=" + placa + "]";
	}
	// SET Y GET
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Renta> getRentas() {
		return rentas;
	}

	public void setRentas(List<Renta> rentas) {
		this.rentas = rentas;
	}

	public LocalDateTime getAnio() {
		return anio;
	}

	public void setAnio(LocalDateTime anio) {
		this.anio = anio;
	}

	public String getModelo() {
		return modelo; 
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}

package com.example.demo.tarea13.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.tarea13.modelo.Automovil;

public interface IAutomovilService {

	public void insertar(Automovil automovil);
	
	// TYPED QUERY
	public Automovil buscarPlacaTyped(String placa);
	public List<Automovil> buscarMarcaTyped(String marca);
	public List<Automovil> buscarModeloTyped(String modelo);

	// NAMED QUERY
	public List<Automovil> buscarPrecioNamed(BigDecimal precio);
	public List<Automovil> buscarMotorNamed(String motor);
	public List<Automovil> buscarAnioNamed(String anio);

	// NATIVE QUERY
	public Boolean buscarExisteColorNative(String color);
	public Integer buscarCantidadMarcaYModeloNative(String marca, String modelo);
	public List<Automovil> buscarPrecioYMotorNative(BigDecimal precio, String motor);

	// NAMED NATIVE QUERY
	public Automovil buscarFirstColorYMarcaNativeNamed(String color, String marca);
	public Automovil buscarFirstPrecioYModeloNativeNamed(BigDecimal precio, String modelo);
	public Automovil buscarFirstMotorYAnioNativeNamed(String motor, String anio);
}

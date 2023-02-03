package com.example.demo.tarea11.service;

import com.example.demo.tarea11.modelo.Vehiculo;

public interface IVehiculoService {

	public void crear(Vehiculo vehiculo);
	public void modificar(Vehiculo vehiculo);
	public Vehiculo buscar(String placa);
	public void eliminar(String placa);
	
}

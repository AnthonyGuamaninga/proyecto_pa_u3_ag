package com.example.demo.tarea11.service;

import com.example.demo.tarea11.modelo.Renta;

public interface IRentaService {
	
	public void registrar(String cedula, String placa);
	public void modificar(Renta renta);
	public Renta buscar(Integer id);
	public void eliminar(Integer id);

}

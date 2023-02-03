package com.example.demo.tarea11.repository;

import com.example.demo.tarea11.modelo.Renta;

public interface IRentaRepo {
	
	public void insertar(Renta renta);
	public void actualizar(Renta renta);
	public Renta buscar(Integer id);
	public void eliminar(Integer id);

}

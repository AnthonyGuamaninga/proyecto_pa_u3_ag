package com.example.demo.tarea11.repository;

import com.example.demo.tarea11.modelo.Cliente;

public interface IClienteRepo {
	
	public void insertar(Cliente cliente);
	public void actualizar(Cliente cliente);
	public Cliente buscar(String cedula);
	public void eliminar(String cedula);

}

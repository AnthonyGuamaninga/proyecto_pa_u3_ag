package com.example.demo.tarea11.service;

import com.example.demo.tarea11.modelo.Cliente;

public interface IClienteService {

	public void registrar(Cliente cliente);
	public void modificar(Cliente cliente);
	public Cliente buscar(String cedula);
	public void eliminar(String cedula);
	
}

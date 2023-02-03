package com.example.demo.tarea11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.tarea11.modelo.Cliente;
import com.example.demo.tarea11.repository.IClienteRepo;
@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteRepo clienteRepo;
	@Override
	public void registrar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public void modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizar(cliente);
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscar(cedula);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.clienteRepo.eliminar(cedula);
	}

}

package com.example.demo.tarea11.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.tarea11.modelo.Cliente;
import com.example.demo.tarea11.modelo.Renta;
import com.example.demo.tarea11.modelo.Vehiculo;
import com.example.demo.tarea11.repository.IRentaRepo;

@Service
public class RentaServiceImpl implements IRentaService{
	@Autowired
	private IRentaRepo iRentaRepo;
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IVehiculoService iVehiculoService;

	@Override
	public void registrar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Renta renta = new Renta();
		Cliente cliente= this.clienteService.buscar(cedula);
		Vehiculo vehiculo = this.iVehiculoService.buscar(placa);
		renta.setCliente(cliente);
		renta.setVehiculo(vehiculo);
		BigDecimal precioVehiculo = vehiculo.getValor();
		renta.setNumeroDias(5);
		//calculo de valor total por la cantidad de dias
		BigDecimal dias= new BigDecimal(renta.getNumeroDias());
		renta.setValor(precioVehiculo.multiply(dias));
		renta.setFecha(LocalDateTime.now());
		
		this.iRentaRepo.insertar(renta);
	}

	@Override
	public void modificar(Renta renta) {
		// TODO Auto-generated method stub
		this.iRentaRepo.actualizar(renta);
	}

	@Override
	public Renta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iRentaRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iRentaRepo.eliminar(id);
	}
	
	
}

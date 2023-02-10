package com.example.demo.tarea13.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.tarea13.modelo.Automovil;
import com.example.demo.tarea13.repository.IAutomovilRepo;

@Service
public class AutomovilServiceImpl implements IAutomovilService {

	@Autowired 
	private IAutomovilRepo automovilRepo;
	
	@Override
	public void insertar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.automovilRepo.insertar(automovil);
	}
	
	@Override
	public Automovil buscarPlacaTyped(String placa) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarPlacaTyped(placa);
	}

	@Override
	public List<Automovil> buscarMarcaTyped(String marca) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarMarcaTyped(marca);
	}

	@Override
	public List<Automovil> buscarModeloTyped(String modelo) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarModeloTyped(modelo);
	}

	@Override
	public List<Automovil> buscarPrecioNamed(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarPrecioNamed(precio);
	}

	@Override
	public List<Automovil> buscarMotorNamed(String motor) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarMotorNamed(motor);
	}

	@Override
	public List<Automovil> buscarAnioNamed(String anio) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarAnioNamed(anio);
	}

	@Override
	public Boolean buscarExisteColorNative(String color) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarExisteColorNative(color);
	}

	@Override
	public Integer buscarCantidadMarcaYModeloNative(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarCantidadMarcaYModeloNative(marca, modelo);
	}

	@Override
	public List<Automovil> buscarPrecioYMotorNative(BigDecimal precio, String motor) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarPrecioYMotorNative(precio, motor);
	}

	@Override
	public Automovil buscarFirstColorYMarcaNativeNamed(String color, String marca) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarFirstColorYMarcaNativeNamed(color, marca);
	}

	@Override
	public Automovil buscarFirstPrecioYModeloNativeNamed(BigDecimal precio, String modelo) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarFirstPrecioYModeloNativeNamed(precio, modelo);
	}

	@Override
	public Automovil buscarFirstMotorYAnioNativeNamed(String motor, String anio) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarFirstMotorYAnioNativeNamed(motor, anio);
	}

	

}

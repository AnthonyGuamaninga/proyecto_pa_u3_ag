package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.tarea11.modelo.Cliente;
import com.example.demo.tarea11.modelo.Vehiculo;
import com.example.demo.tarea11.service.IClienteService;
import com.example.demo.tarea11.service.IRentaService;
import com.example.demo.tarea11.service.IVehiculoService;

@SpringBootApplication
public class TareasPaU3AgApplication implements CommandLineRunner{

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IRentaService iRentaService;
	
	public static void main(String[] args){
		SpringApplication.run(TareasPaU3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//FUNCIONALIDAD 1
		Cliente cliente= new Cliente();
		cliente.setCedula("1953100110");
		cliente.setNombre("Tedeo");
		cliente.setFechaNacimiento(LocalDateTime.of(2003, 3,8,12,21));
		cliente.setNumeroTelefono("0989446111");
		this.clienteService.registrar(cliente);
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca("PDZ-4244");
		vehiculo.setAnio(LocalDateTime.of(2015, 1,1,00,00));
		vehiculo.setMarca("KIA");
		vehiculo.setModelo("europa");
		vehiculo.setValor(new BigDecimal(500));
		this.iVehiculoService.crear(vehiculo);
		
		//FUNCIONALIDAD 2
		this.iRentaService.registrar(cliente.getCedula(), vehiculo.getPlaca());
		
	}

}

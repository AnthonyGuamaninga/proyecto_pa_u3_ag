package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.tarea11.modelo.Cliente;
import com.example.demo.tarea11.modelo.Vehiculo;
import com.example.demo.tarea11.service.IClienteService;
import com.example.demo.tarea11.service.IRentaService;
import com.example.demo.tarea11.service.IVehiculoService;
import com.example.demo.tarea13.modelo.Automovil;
import com.example.demo.tarea13.service.IAutomovilService;

@SpringBootApplication
public class TareasPaU3AgApplication implements CommandLineRunner{

	@Autowired
	private IAutomovilService automovilService;
	
	public static void main(String[] args){
		SpringApplication.run(TareasPaU3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insercion 
		Automovil automovil = new Automovil();
		automovil.setPlaca("PDZ-1142");
		automovil.setPrecio(new BigDecimal(50100));
		automovil.setMotor("V6");
		automovil.setModelo("RX");
		automovil.setMarca("Lexus");
		automovil.setColor("Morado");
		automovil.setAnio("2023");
		//this.automovilService.insertar(automovil);
		
		// TYPED QUERY
		System.out.println("----> TYPED QUERY");
		Automovil automovil2= this.automovilService.buscarPlacaTyped("PDZ-1142");
		System.out.println(automovil2+"\n");
		
		List<Automovil> autoList=this.automovilService.buscarMarcaTyped("KIA");
		for(Automovil a:autoList) {
			System.out.println(a);
		}System.out.println();
		
		List<Automovil> autoList1=this.automovilService.buscarModeloTyped("RX");
		for(Automovil a:autoList1) {
			System.out.println(a);
		} System.out.println();
		
		// NAMED QUERY
		System.out.println("----> NAMED QUERY");
		List<Automovil> autoList2=this.automovilService.buscarPrecioNamed(new BigDecimal(30500));
		for(Automovil a:autoList2) {
			System.out.println(a);
		} System.out.println();
		
		List<Automovil> autoList3=this.automovilService.buscarMotorNamed("cuatro cilindros");
		for(Automovil a:autoList3) {
			System.out.println(a);
		} System.out.println();
		
		List<Automovil> autoList4=this.automovilService.buscarAnioNamed("2018");
		for(Automovil a:autoList4) {
			System.out.println(a);
		} System.out.println();
		
		// NATIVE QUERY
		System.out.println("----> NATIVE QUERY");
		Boolean existe = this.automovilService.buscarExisteColorNative("Rojo");
		System.out.println("Ya NO hay carros de color Rojo?: "+existe+"\n");
		
		Integer cantidad = this.automovilService.buscarCantidadMarcaYModeloNative("KIA", "Stonic Europa");
		System.out.println("Cantidad de autos KIA Stonic Europa hay?: "+cantidad+"\n" );
		
		List<Automovil> autoList5=this.automovilService.buscarPrecioYMotorNative(new BigDecimal(20000), "V6");
		for(Automovil a:autoList5) {
			System.out.println(a);
		} System.out.println();
		
		// NAMED NATIVE QUERY
		System.out.println("----> NAMED NATIVE QUERY");
		Automovil automovil3 = this.automovilService.buscarFirstColorYMarcaNativeNamed("Blanco", "KIA");
		System.out.println(automovil3+"\n");
		
		Automovil automovil4 = this.automovilService.buscarFirstPrecioYModeloNativeNamed(new BigDecimal(30500), "Ridgeline");
		System.out.println(automovil4+"\n");
		
		Automovil automovil5 = this.automovilService.buscarFirstMotorYAnioNativeNamed("V6", "2020");
		System.out.println(automovil5+"\n");
	}

}

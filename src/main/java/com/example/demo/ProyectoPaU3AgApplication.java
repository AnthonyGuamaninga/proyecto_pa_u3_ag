package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.uce.modelo.Estudiante;
import com.example.demo.uce.service.IEstudianteService;

@SpringBootApplication
public class ProyectoPaU3AgApplication  implements CommandLineRunner{

	@Autowired
	private IEstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		int cantidad = this.estudianteService.actualizarPorNombre("Lucia", "Bailar");
		System.out.println("Datos actualizados por nombre: "+cantidad+"\n");
		
		int cantidad1 = this.estudianteService.actualizarPorCiudadYGenero("Machala", "M", new BigDecimal(1050));
		System.out.println("Datos actualizados por ciudad y genero: "+cantidad1+"\n");
		
		int cantidad2= this.estudianteService.eliminarPorGeneroYFecha("Sin genero", LocalDateTime.of(2001, 01,29,0,0));
		System.out.println("Datos eliminados por genero y fecha: "+cantidad2+"\n");
		
		int cantidad3 = this.estudianteService.eliminarPorApellidoYSalario("Torres", new BigDecimal(800));
		System.out.println("Datos eliminados por apellido y salario: "+cantidad3+"\n");
		
		
	}

}

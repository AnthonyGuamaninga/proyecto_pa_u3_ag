package com.example.demo;

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
		
		/*
		int salidaEliminar = this.estudianteService.eliminarPorApellido("Ceri");
		System.out.println("Consulta Eliminar: "+salidaEliminar);
		
		int salidaActualizar = this.estudianteService.actualizarPorApellido("Paredes", "Rebeca");
		System.out.println("Consulta Actualizar: "+salidaActualizar);
		*/
		Estudiante estudiante = new Estudiante(); 
		estudiante.setApellido(null);
		
	}

}

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
		
		EstudianteDTO dto= this.estudianteService.buscarPorNombreQueryTypedDTO("Anthony");
		System.out.println("DTO: "+dto);
		
		Estudiante estudiante = this.estudianteService.buscarPornombreCriteria("Carlos");
		System.out.println("Criteria API Query: "+estudiante);
		
		System.out.println();
		List<Estudiante> estudiantes = this.estudianteService.buscarPornombreCriteriaAndOr("Sandra","Paredes","M");
		System.out.println();
		List<Estudiante> estudiantes2 = this.estudianteService.buscarPornombreCriteriaAndOr("Luis", "Palacios", "F");
	}

}

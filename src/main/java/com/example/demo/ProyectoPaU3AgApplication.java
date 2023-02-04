package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		//Estudiante estudiante = this.estudianteService.buscarNombre("Carlos");
		//System.out.println(estudiante+"\n");
		
		Estudiante estudiante2 = this.estudianteService.buscarNombreTypedQuery("David");
		System.out.println("Consulta 1: "+ estudiante2);
		
		Estudiante estudiante3 = this.estudianteService.buscarPorNombreNamedQuery("Sandra");
		System.out.println("Consulta 2: "+estudiante3);
		
		Estudiante estudiante4 = this.estudianteService.buscarPorNombreNamedQueryTyped("Carlos");
		System.out.println("Consulta 3: "+estudiante4);
		
		Estudiante estudiante5 = this.estudianteService.buscarPorNombreNativeQuery("David");
		System.out.println("Consulta 4: "+estudiante5);
		
		//Estudiante estudiante4 = this.estudianteService.buscarPorNombreNativeQueryTypedNamed("Carlos");
		//System.out.println(estudiante4);
		

		/*
		// CONSULTA 1:
		Estudiante estudiante2= this.estudianteService.buscarApellido("Torres");
		System.out.println(estudiante2+"\n");
		
		// CONSULTA 2:
		Estudiante estudiante3 = this.estudianteService.buscarGenero("Bigenero");
		System.out.println(estudiante3+"\n");
		
		// CONSULTA 3:
		Estudiante estudiante4 = this.estudianteService.buscarCedula("1553100766");
		System.out.println(estudiante4+"\n");
		
		// CONSULTA 4:
		Estudiante estudiante5 = this.estudianteService.buscarCiudad("Manta");
		System.out.println(estudiante5+"\n");
		*/
	}

}

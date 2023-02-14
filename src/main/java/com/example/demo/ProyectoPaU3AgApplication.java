package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.uce.modelo.Estudiante;
import com.example.demo.uce.modelo.Habitacion;
import com.example.demo.uce.modelo.Hotel;
import com.example.demo.uce.service.IEstudianteService;
import com.example.demo.uce.service.IHotelService;

@SpringBootApplication
public class ProyectoPaU3AgApplication  implements CommandLineRunner{

	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Hotel> hotels= this.hotelService.buscarHotelInnerJoin("VIP");
		for(Hotel h: hotels) {
			System.out.println(h.getNombre());
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println("La habitacion es: "+ha.getNumero());
			}
			
		}
		/*
		System.out.println();
		List<Hotel> hotels3=this.hotelService.buscarHotelOuterLeftJoin("VIP");
		for(Hotel h: hotels3) {
			System.out.println(h.getNombre());
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println("La habitacion es: "+ha.getNumero());
			}
			
		}*/
		
		/*List<Hotel> hotels2= this.hotelService.buscarHotelOuterRightJoin("VIP");
		for(Hotel h: hotels2) {
			System.out.println(h.getNombre());
			
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println("La habitacion es: "+ha.getNumero());
			}
			
		}*/
		
		
		/*
		List<Hotel> hotels4=this.hotelService.buscarHotelOuterFullJoin(null);
		for(Hotel h: hotels4) {
			System.out.println(h);
		}
		
		List<Hotel> hotels5=this.hotelService.buscarHotelFetchJoin(null);
		for(Hotel h: hotels5) {
			System.out.println(h);
		}
		*/
		
	}

}

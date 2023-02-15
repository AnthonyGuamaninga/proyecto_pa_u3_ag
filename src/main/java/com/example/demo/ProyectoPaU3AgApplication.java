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
import com.example.demo.uce.service.IHabitacionService;
import com.example.demo.uce.service.IHotelService;

@SpringBootApplication
public class ProyectoPaU3AgApplication  implements CommandLineRunner{

	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("\n >>>> FETCH JOIN");
		System.out.println();
		List<Hotel> hotels3=this.hotelService.buscarHotelOuterLeftJoin("VIP");
		for(Hotel h: hotels3) {
			System.out.println(h.getNombre());
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println("La habitacion es: "+ha.getNumero()+" de tipo "+ha.getTipo());
			}
			
		}
		
		System.out.println("\n >>>> LEFT JOIN");
		System.out.println();
		List<Hotel> hotels4=this.hotelService.buscarHotelOuterLeftJoin();
		for(Hotel h: hotels4) {
			System.out.println(h.getNombre());
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
		}
		
		System.out.println();
		List<Habitacion> habitacions=this.habitacionService.buscarHabitacionOuterLeftJoin();
		for(Habitacion ha: habitacions) {
			System.out.println(ha!=null? ha.getNumero():null);
		}
		
		// RIGHT JOIN
		
		System.out.println("\n >>>> RIGHT JOIN");
		List<Hotel> hotels5=this.hotelService.buscarHotelOuterRightJoin();
		for(Hotel h: hotels5) {
			System.out.println(h!=null? h.getNombre(): null);
//			for(Habitacion ha: h.getHabitaciones() ) {
//				System.out.println(ha!=null? ha.getNumero(): null);
//			}
		}
		
		
		System.out.println();
		List<Habitacion> habitacions2=this.habitacionService.buscarHabitacionOuterRightJoin();
		for(Habitacion ha: habitacions2) {
			System.out.println(ha!=null? ha.getNumero():null);
			System.out.println(ha.getHotel());
		}
		
		
	}

}

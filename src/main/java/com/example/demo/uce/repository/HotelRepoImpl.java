package com.example.demo.uce.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.modelo.Habitacion;
import com.example.demo.uce.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		// SELECT h.hote_nombre, ha.habi_numero FROM hotel h INNER JOIN habitacion ha on h.hote_id=ha.habi_id_hotel where ha.habi_tipo='VIP'
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha WHERE ha.tipo=:datoTipo ", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		
		List<Hotel> hotels = query.getResultList();
		//BAJO DEMANDA
		for(Hotel h: hotels) {
			List<Habitacion> listaTmp=new ArrayList<>();
			for(Habitacion ha: h.getHabitaciones()) {
				if(ha.getTipo().equals(tipoHabitacion)) {
					listaTmp.add(ha);
				}
			}
			h.setHabitaciones(listaTmp);
		}
		return hotels;
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo=:datoTipo ", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		//BAJO DEMANDA
		List<Hotel> hotels = query.getResultList();
		/*
		for(Hotel h: hotels) {
			h.getHabitaciones().size();
		}*/
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo=:datoTipo ", Hotel.class);
		query.setParameter("datoTipo", tipoHabitacion);
		//BAJO DEMANDA
		List<Hotel> hotels = query.getResultList();
		for(Hotel h: hotels) {
			h.getHabitaciones().size();
		}
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",
				Hotel.class);
		
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);
		List<Hotel> hotels = query.getResultList();
		for(Hotel h: hotels) {
			h.getHabitaciones().size();
		}
		return hotels;
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones ha",
				Hotel.class);
		List<Hotel> hotels = query.getResultList();
		for(Hotel h: hotels) {
			h.getHabitaciones().size();
		}
		return hotels;
	}

}

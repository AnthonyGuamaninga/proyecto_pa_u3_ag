package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.uce.modelo.Habitacion;

public interface IHabitacionRepo {
	
	public List<Habitacion> buscarHabitacionInnerJoin(String tipoHabitacion);
	public List<Habitacion> buscarHabitacionOuterRightJoin(String tipoHabitacion);
	public List<Habitacion> buscarHabitacionOuterLeftJoin(String tipoHabitacion);
	public List<Habitacion> buscarHabitacionOuterFullJoin(String tipoHabitacion);
	public List<Habitacion> buscarHabitacionFetchJoin(String tipoHabitacion);
	
	// sin parametros
	public List<Habitacion> buscarHabitacionOuterRightJoin();
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	public List<Habitacion> buscarHabitacionOuterFullJoin();

}

package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.uce.modelo.Estudiante;

public interface IEstudianteService {
	
	public Estudiante buscarNombre(String nombre);
	public Estudiante buscarApellido(String apellido);
	public Estudiante buscarGenero(String genero);
	public Estudiante buscarCedula(String cedula);
	public Estudiante buscarCiudad(String ciudad);

	public Estudiante buscarNombreTypedQuery(String nombre);
	
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	 
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre);
	
	//Native
	public Estudiante buscarPorNombreNativeQuery(String nombre);
	// Combinacion Native Type Named
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre);

	
	public List<Estudiante> buscarPorNombreQueryList(String nombre);
	public Estudiante buscarPorNombreQueryListFirst(String nombre);

	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre);

	//DTO
	public EstudianteDTO buscarPorNombreQueryTypedDTO(String nombre);
	// CRITERIA API
	public Estudiante buscarPornombreCriteria(String nombre);
	
	public List<Estudiante> buscarPornombreCriteriaAndOr(String nombre, String apellido, String genero);

	
}

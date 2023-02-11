package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.uce.modelo.Estudiante;

public interface IEstudianteRepo {
	public void insertar(Estudiante estudiante);
	
	public Estudiante buscarPorNombreQuery(String nombre);
	public Estudiante buscarPorApellidoQuery(String apellido);
	public Estudiante buscarPorGeneroQuery(String genero);
	public Estudiante buscarPorCedulaQuery(String cedula);
	public Estudiante buscarPorCiudadQuery(String ciudad);
	// Typed Query
	public Estudiante buscarPorNombreTypedQuery(String nombre);
	// Named Query
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	// Combinado 
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre);
	
	//Native
	public Estudiante buscarPorNombreNativeQuery(String nombre);
	// Combinacion Native Type Named
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre);

	//Uso de List
	public List<Estudiante> buscarPorNombreQueryList(String nombre);
	public Estudiante buscarPorNombreQueryListFirst(String nombre);
	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre);
	public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre);
	// DTO
	public EstudianteDTO buscarPorNombreQueryTypedDTO(String nombre);

	// API QUERY
	public Estudiante buscarPornombreCriteria(String nombre);
	public List<Estudiante> buscarPornombreCriteriaAndOr(String nombre, String apellido, String genero);

	
	public int eliminarPorApellido(String apellido);
	public int actualizarPorApellido(String apellido, String nombre);

	
}

package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.uce.modelo.Estudiante;

public interface IEstudianteRepo {
	
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

	
	public List<Estudiante> buscarPorNombreQueryList(String nombre);
	public Estudiante buscarPorNombreQueryListFirst(String nombre);
	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre);
	public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre);

	public EstudianteDTO buscarPorNombreQueryTypedDTO(String nombre);

}

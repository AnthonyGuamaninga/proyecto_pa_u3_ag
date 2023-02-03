package com.example.demo.uce.service;

import com.example.demo.uce.modelo.Estudiante;

public interface IEstudianteService {
	
	public Estudiante buscarNombre(String nombre);
	public Estudiante buscarApellido(String apellido);
	public Estudiante buscarGenero(String genero);
	public Estudiante buscarCedula(String cedula);
	public Estudiante buscarCiudad(String ciudad);

}

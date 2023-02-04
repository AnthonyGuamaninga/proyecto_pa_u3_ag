package com.example.demo.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.modelo.Estudiante;
import com.example.demo.uce.repository.IEstudianteRepo;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public Estudiante buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreQuery(nombre);
	}

	@Override
	public Estudiante buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorApellidoQuery(apellido);
	}

	@Override
	public Estudiante buscarGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorGeneroQuery(genero);
	}

	@Override
	public Estudiante buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorCedulaQuery(cedula);
	}

	@Override
	public Estudiante buscarCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorCiudadQuery(ciudad);
	}

	@Override
	public Estudiante buscarNombreTypedQuery(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreTypedQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreNamedQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreNamedQueryTyped(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreNativeQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreNativeQueryTypedNamed(nombre);
	}

}

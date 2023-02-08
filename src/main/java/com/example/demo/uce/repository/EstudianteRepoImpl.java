package com.example.demo.uce.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.uce.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante buscarPorNombreQuery(String nombre) {
		// TODO Auto-generated method stub
		// select * from estudiante where estu_nombre = 'Sandra' ----> SQL
		// select e from Estudiante e where e.nombre = :datoNombre ---> JPQL
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return (Estudiante) jpqlQuery.getSingleResult(); // retorna un objeto de tipo generico por eso es necesario un
															// cast
	}

	@Override
	public Estudiante buscarPorApellidoQuery(String apellido) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");
		query.setParameter("datoApellido", apellido);
		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante buscarPorGeneroQuery(String genero) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select e from Estudiante e where e.genero = :datoGenero");
		query.setParameter("datoGenero", genero);
		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCedulaQuery(String cedula) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select e from Estudiante e where e.cedula = :datoCedula");
		query.setParameter("datoCedula", cedula);
		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCiudadQuery(String ciudad) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select e from Estudiante e where e.ciudad = :datoCiudad");
		query.setParameter("datoCiudad", ciudad);
		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTipedQuery = this.entityManager
				.createQuery("select e from Estudiante e where e.nombre = :datoNombre", Estudiante.class);
		myTipedQuery.setParameter("datoNombre", nombre);
		return myTipedQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre",
				Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("select * from estudiante where estu_nombre = :datoNombre",
				Estudiante.class); // Sentencia SQL
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative",
				Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreQueryList(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return jpqlQuery.getResultList();

	}

	@Override
	public Estudiante buscarPorNombreQueryListFirst(String nombre) {
		Query jplQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
		jplQuery.setParameter("datoNombre", nombre);
		return (Estudiante) jplQuery.getResultList().get(0);
	}

	@Override
	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre1");
		myQuery.setParameter("datoNombre", nombre);
		return (List<Estudiante>) myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstudianteDTO buscarPorNombreQueryTypedDTO(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteDTO> myQuery = this.entityManager.createQuery("SELCT new EstudianteDTO(e.nombre, e.apellido, e.cedula from Estudiante e where e.nombre = :datoNombre",
				EstudianteDTO.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

}

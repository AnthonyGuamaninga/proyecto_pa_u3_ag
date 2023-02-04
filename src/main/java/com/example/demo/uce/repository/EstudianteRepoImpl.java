package com.example.demo.uce.repository;

import org.springframework.stereotype.Repository;

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
		// select * from estudiante where estu_nombre = 'Sandra'   ----> SQL
		// select e from Estudiante e where e.nombre = :datoNombre   ---> JPQL
		Query jpqlQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		return (Estudiante) jpqlQuery.getSingleResult(); // retorna un objeto de tipo generico por eso es necesario un cast
	}

	@Override
	public Estudiante buscarPorApellidoQuery(String apellido) {
		// TODO Auto-generated method stub
		Query query= this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");
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
		Query query= this.entityManager.createQuery("select e from Estudiante e where e.ciudad = :datoCiudad");
		query.setParameter("datoCiudad", ciudad);
		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTipedQuery = this.entityManager.createQuery("select e from Estudiante e where e.nombre = :datoNombre", Estudiante.class);
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
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("select * from estudiante where estu_nombre = :datoNombre", Estudiante.class); //Sentencia SQL
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}


	

}

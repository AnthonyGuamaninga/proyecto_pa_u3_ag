package com.example.demo.uce.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.uce.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

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
		TypedQuery<EstudianteDTO> myQuery = this.entityManager.createQuery(
				"select NEW com.example.demo.modelo.dto.EstudianteDTO(e.nombre, e.apellido, e.cedula, e.genero) from Estudiante e where e.nombre = :datoNombre",
				EstudianteDTO.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList().get(0);
	}

	@Override
	public Estudiante buscarPornombreCriteria(String nombre) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		// Especificamos el tipo de retorno de my QUERY
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		
		// Aqui empezamos a crear el SQL 
		// Definiendo el FROM-Root
		Root<Estudiante> miTablaFrom = myQuery.from(Estudiante.class);  // root de tipo Estudiante, FROM Estudiante		
		
		// Las condiciones WHERRE se conoccen en CriteriaAPI query como predicados
		// e.nombre = :datoNombre
		Predicate condicion1 = myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		
		myQuery.select(miTablaFrom).where(condicion1);
		// Declarado/Armado mi Query.
		
		// La ejecucion de Query lo realizamos con cualquier tipo ya conocido: TypedQuery
		TypedQuery<Estudiante> mySQL = this.entityManager.createQuery(myQuery);
		
		return mySQL.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPornombreCriteriaAndOr(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		// Especificamos el tipo de retorno de my QUERY
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);

		// Aqui empezamos a crear el SQL
		// Definiendo el FROM-Root
		Root<Estudiante> miTablaFrom = myQuery.from(Estudiante.class); // root de tipo Estudiante, FROM Estudiante
		
		// M: e.nombre= AND e.apellido=
		// F: e.nombre= OR e.apellido=
		// Creamos los predicados
		// Predicado del nombre
		Predicate p1 = myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		
		// Predicado del apellido
		Predicate p2 = myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		
		Predicate predicadoFinal=null;
		if(genero.equals("M")) {
			// Predicado de AND
			predicadoFinal = myBuilder.and(p1,p2);
		}else {
			// Predicado de OR
			predicadoFinal = myBuilder.or(p1, p2);
		}

		myQuery.select(miTablaFrom).where(predicadoFinal);
		// Declarado/Armado mi Query.

		// La ejecucion de Query lo realizamos con cualquier tipo ya conocido:
		// TypedQuery
		TypedQuery<Estudiante> mySQL = this.entityManager.createQuery(myQuery);

		return mySQL.getResultList();
	}

	@Override
	public int eliminarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// DELETE FROM estudiante where estu_apellido = 'Chacal'
		Query query= this.entityManager.createQuery("DELETE FROM Estudiante e WHERE e.apellido= :datoApellido");
		query.setParameter("datoApellido", apellido);
		return query.executeUpdate();
	}

	@Override
	public int actualizarPorApellido(String apellido, String nombre) {
		// TODO Auto-generated method stub
		// UPDATE estudiante set estu_nombre= 'Edison' WHERE estu_apellido='Cayambe'
		Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre= :datoNombre WHERE e.apellido= :datoApellido");
		query.setParameter("datoNombre", nombre);
		query.setParameter("datoApellido", apellido);
		return query.executeUpdate();
	}

	

}

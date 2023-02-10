package com.example.demo.tarea13.repository;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.example.demo.tarea13.modelo.Automovil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutomovilRepoImpl implements IAutomovilRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.entityManager.persist(automovil);
	}

	@Override
	public Automovil buscarPlacaTyped(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Automovil> query = this.entityManager
				.createQuery("select a from Automovil a where a.placa = :datoPlaca", Automovil.class);
		query.setParameter("datoPlaca", placa);
		return query.getSingleResult();
	}

	@Override
	public List<Automovil> buscarMarcaTyped(String marca) {
		// TODO Auto-generated method stub
		TypedQuery<Automovil> query = this.entityManager
				.createQuery("select a from Automovil a where a.marca = :datoMarca", Automovil.class);
		query.setParameter("datoMarca", marca);
		return query.getResultList();
	}

	@Override
	public List<Automovil> buscarModeloTyped(String modelo) {
		// TODO Auto-generated method stub
		TypedQuery<Automovil> query = this.entityManager
				.createQuery("select a from Automovil a where a.modelo = :datoModelo", Automovil.class);
		query.setParameter("datoModelo", modelo);
		return query.getResultList();
	}

	@Override
	public List<Automovil> buscarPrecioNamed(BigDecimal precio) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNamedQuery("Automovil.buscarPrecio");
		query.setParameter("datoPrecio", precio);
		return query.getResultList();
	}

	@Override
	public List<Automovil> buscarMotorNamed(String motor) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNamedQuery("Automovil.buscarMotor");
		query.setParameter("datoMotor", motor);
		return query.getResultList();
	}

	@Override
	public List<Automovil> buscarAnioNamed(String anio) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNamedQuery("Automovil.buscarAnio");
		query.setParameter("datoAnio", anio);
		return query.getResultList();
	}

	@Override
	public Boolean buscarExisteColorNative(String color) {
		// TODO Auto-generated method stub
		Query nativeQuery = this.entityManager
				.createNativeQuery("select * from automovil where auto_color = :datoColor", Automovil.class);
		nativeQuery.setParameter("datoColor", color);
		return nativeQuery.getResultList().isEmpty();
	}

	@Override
	public Integer buscarCantidadMarcaYModeloNative(String marca, String modelo) {
		// TODO Auto-generated method stub
		Query nativeQuery = this.entityManager.createNativeQuery(
				"select * from automovil where auto_marca = :datoMarca and auto_modelo= :datoModelo", Automovil.class);
		nativeQuery.setParameter("datoMarca", marca);
		nativeQuery.setParameter("datoModelo", modelo);
		return nativeQuery.getResultList().size();
	}

	@Override
	public List<Automovil> buscarPrecioYMotorNative(BigDecimal precio, String motor) {
		// TODO Auto-generated method stub
		Query nativeQuery = this.entityManager.createNativeQuery(
				"select * from automovil where auto_precio = :datoPrecio and auto_motor= :datoMotor", Automovil.class);
		nativeQuery.setParameter("datoPrecio", precio);
		nativeQuery.setParameter("datoMotor", motor);
		return nativeQuery.getResultList();
	}

	@Override
	public Automovil buscarFirstColorYMarcaNativeNamed(String color, String marca) {
		// TODO Auto-generated method stub
		Query nativeQuery = this.entityManager.createNamedQuery(
				"Automovil.FirstColorYMarca");
		nativeQuery.setParameter("datoColor", color);
		nativeQuery.setParameter("datoMarca", marca);
		return (Automovil) nativeQuery.getResultList().get(0);
	}

	@Override
	public Automovil buscarFirstPrecioYModeloNativeNamed(BigDecimal precio, String modelo) {
		// TODO Auto-generated method stub
		Query nativeQuery = this.entityManager.createNamedQuery(
				"Automovil.FirstPrecioYModelo");
		nativeQuery.setParameter("datoPrecio", precio);
		nativeQuery.setParameter("datoModelo", modelo);
		return (Automovil) nativeQuery.getResultList().get(0);
	}

	@Override
	public Automovil buscarFirstMotorYAnioNativeNamed(String motor, String anio) {
		// TODO Auto-generated method stub
		Query nativeQuery = this.entityManager.createNamedQuery(
				"Automovil.FirstMotorYAño");
		nativeQuery.setParameter("datoMotor", motor);
		nativeQuery.setParameter("datoAnio", anio);
		return (Automovil) nativeQuery.getResultList().get(0);
	}

}

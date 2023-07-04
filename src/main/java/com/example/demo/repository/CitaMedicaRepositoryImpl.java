package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertaCita(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
		
	}

	@Override
	public void actualizarCita(CitaMedica citaMedica) {
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica selecionarPorNumeroCita(String numeroCita) {
		TypedQuery<CitaMedica> myQuery=this.entityManager.createQuery("select e from CitaMedica e where e.numeroCita = :datoNumeroCita", CitaMedica.class);
		myQuery.setParameter("datoNumeroCita",numeroCita);
		return myQuery.getSingleResult();
	}

}

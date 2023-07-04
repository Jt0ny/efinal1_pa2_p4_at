package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PacienterRepositoryImpl implements PacienteRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);
		
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
		
	}

	@Override
	public Paciente seleccionar(String cedula) {
		
		return this.entityManager.find(Paciente.class, cedula);
	}

	

}

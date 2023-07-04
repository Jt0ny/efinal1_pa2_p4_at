package com.example.demo.repository;

import com.example.demo.repository.modelo.CitaMedica;

public interface CitaMedicaRepository {
	
	public void insertaCita (CitaMedica citaMedica);
	
	public void actualizarCita(CitaMedica citaMedica);
	
	public CitaMedica selecionarPorNumeroCita(String numeroCita);

}

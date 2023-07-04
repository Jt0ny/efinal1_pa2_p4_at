package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CitaMedicaRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{

	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired 
	private PacienteRepository pacienteRepository;
	

	@Override
	public void agendarCita(String numeroCita, LocalDate fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		Doctor doc=this.doctorRepository.seleccionar(cedulaDoctor);
		Paciente paci =this.pacienteRepository.seleccionar(cedulaPaciente);
		
		CitaMedica citaMedica= new CitaMedica();
		citaMedica.setNumeroCita(numeroCita);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValorCita(valorCita);
		citaMedica.setLugarCita(lugarCita);
		citaMedica.setDoctor(doc);
		citaMedica.setPaciente(paci);
		this.citaMedicaRepository.insertaCita(citaMedica);
		
	}


	@Override
	public void actualizarCita(String numeroCita,String diagnostico, String receta, LocalDate fechaProximaCita) {
	 
		CitaMedica citaMedica=this.citaMedicaRepository.selecionarPorNumeroCita(numeroCita);
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setFechaProxCita(fechaProximaCita);
		this.citaMedicaRepository.actualizarCita(citaMedica);
		
	}


	

	
	
}

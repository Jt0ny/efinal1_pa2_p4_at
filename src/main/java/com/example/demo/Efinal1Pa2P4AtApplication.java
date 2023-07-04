package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.CitaMedicaService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@SpringBootApplication
public class Efinal1Pa2P4AtApplication implements CommandLineRunner {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private CitaMedicaService citaMedicaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P4AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Doctor doc1= new Doctor();
		doc1.setCedula("123");
		doc1.setNombre("Anthony");
		doc1.setApellido("Tipan");
		doc1.setFechaNacimiento(LocalDate.of(2001, 8, 1));
		doc1.setNumeroConsultorio("001");
		doc1.setCodigoSenescyt("a12");
		doc1.setGenero("Masculino");
		this.doctorService.guardar(doc1);
		
		Paciente paci1= new Paciente ();
		paci1.setCedula("456");
		paci1.setNombre("Joel");
		paci1.setApellido("Oña");
		paci1.setFechaNacimiento(LocalDate.of(2006, 8, 7));
		paci1.setCodigoSeguro("q78");
		paci1.setEstatura("1.70m");
		paci1.setPeso("78kg");
		paci1.setGenero("Masculino");
		this.pacienteService.guardar(paci1);
		
		this.citaMedicaService.agendarCita("11", LocalDate.of(2023, 9, 1), new BigDecimal(30), "Quito", "123","456");
		this.citaMedicaService.actualizarCita("11", "Gripe", "Jarabe", LocalDate.of(2023, 10, 5));
	}

}

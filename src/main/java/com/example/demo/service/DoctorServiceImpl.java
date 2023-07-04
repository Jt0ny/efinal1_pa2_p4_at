package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.modelo.Doctor;
@Service
public class DoctorServiceImpl implements DoctorService {
	

	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public void guardar(Doctor doctor) {
		this.doctorRepository.insertar(doctor);
		
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.doctorRepository.actualizar(doctor);
	}

	@Override
	public Doctor buscar(String cedula) {
		
		return this.doctorRepository.seleccionar(cedula);
	}

	@Override
	public void eliminar(String cedula) {
		this.doctorRepository.borrar(cedula);
		
	}

}

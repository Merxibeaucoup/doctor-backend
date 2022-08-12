package com.edgar.dentist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.dentist.models.DentistPatient;
import com.edgar.dentist.repositories.DentistPatientRepository;
import com.edgar.dentist.services.DentistPatientServices;

@RestController
@RequestMapping("/api/patient")
public class DentistPatientController {
	
	
	@Autowired
	private DentistPatientRepository dRep;
	
	
	@Autowired
	private DentistPatientServices dServ;
	
	
	//create new appointment
	@PostMapping
	public ResponseEntity<DentistPatient> create(@RequestBody DentistPatient dentistPatient){
		DentistPatient newAppointment = dServ.create(dentistPatient);
		return ResponseEntity.ok(newAppointment);
	}
	
	//get all appointments 
	@GetMapping
	public ResponseEntity<List<DentistPatient>> getAll(){
		return ResponseEntity.ok(dServ.getAll());
	}
	
	//get one by id
	@GetMapping("/{id}")
	public ResponseEntity<DentistPatient> getOneById(@PathVariable long id){
		return ResponseEntity.ok(dServ.getOneById(id));
	}
	
	//update one by id 
	@PutMapping("/{id}")
	public ResponseEntity<DentistPatient> updateOneById (@RequestBody DentistPatient dentistPatient, @PathVariable long id){
		return ResponseEntity.ok(dServ.updateOneById(dentistPatient, id));
	}
	
	//delete one by id
	public ResponseEntity<?> deleteOneById(@PathVariable long id){
		return dRep.findById(id)
		           .map(record -> {
		               dRep.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}
}

package com.edgar.dentist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.dentist.models.DentistPatient;
import com.edgar.dentist.repositories.DentistPatientRepository;

@Service
public class DentistPatientServices {
	
	
	@Autowired
	private DentistPatientRepository dpRepo;
	
	//create new
	public DentistPatient create(DentistPatient dentistPatient) {
		return dpRepo.save(dentistPatient);
	}
	
	//get all
	
	public List<DentistPatient> getAll(){
		return dpRepo.findAll();
	}
	
	//get one by id 
	public DentistPatient getOneById(long id) {
		return dpRepo.findById(id).get();
	}
	
	//update one by id 
	public DentistPatient updateOneById(DentistPatient dentistPatient, long id) {
		dpRepo.findById(id);
		dentistPatient.setId(id);
		return dpRepo.save(dentistPatient);
	}
	
	//delete one by id
	public void deleteOneById(long id) {
		dpRepo.deleteById(id);
	}

}

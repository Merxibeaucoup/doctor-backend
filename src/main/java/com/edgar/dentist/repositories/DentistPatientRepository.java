package com.edgar.dentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.dentist.models.DentistPatient;

@Repository
public interface DentistPatientRepository extends JpaRepository<DentistPatient, Long> {

}

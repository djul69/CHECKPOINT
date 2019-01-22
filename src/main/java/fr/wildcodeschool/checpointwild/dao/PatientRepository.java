package fr.wildcodeschool.checpointwild.dao;

import fr.wildcodeschool.checpointwild.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
public Patient findPatientByNumContains(String num_secu);
}

package fr.wildcodeschool.checpointwild.controller;

import fr.wildcodeschool.checpointwild.dao.PatientRepository;
import fr.wildcodeschool.checpointwild.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
public class FullRestController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    private List<Patient> GetAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    private Patient one(@PathVariable Long id) {
        try {
            patientRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Erreur : cet id n'existe pas", e);
        }
        return patientRepository.findById(id).get();
    }

    @DeleteMapping("/patients/{id}")
    private void deletePatient(@PathVariable Long id) {
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erreur : cet id n'existe pas", e);
        }
    }

    @PutMapping("/patients/create")
    private String savePatient(@RequestBody Patient patient) {

        if (patientRepository.findPatientByNumContains(patient.getNum()) != null) {
            return "le patient existe déjà";
        }
        patientRepository.save(patient);
        return "le patient a été enregistré";
    }
}

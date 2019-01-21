package fr.wildcodeschool.checpointwild.controller;

import fr.wildcodeschool.checpointwild.dao.PatientRepository;
import fr.wildcodeschool.checpointwild.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class restController {
    @Autowired
    PatientRepository patientRepository;
    private final String GEOURL = "https://api.gouv.fr/api/api-geo.htmlcommunes";

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

    @PostMapping(GEOURL+"/{code}")
            private void getInfosCommunes(@PathVariable int idCommune){

    }
}
